package com.example.musicplayersam.ui.activity.base

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.transition.TransitionManager
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.R
import com.example.musicplayersam.player.core.IMediaPlayer
import com.example.musicplayersam.ui.activity.MusicPlayerActivity
import com.example.musicplayersam.utils.annotation.DisableLayoutInject
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.ImageLoader
import com.example.musicplayersam.utils.component.log
import com.example.musicplayersam.utils.component.support.attrValue
import com.example.musicplayersam.utils.component.support.observeNonNull
import com.example.musicplayersam.utils.component.support.string
import com.example.musicplayersam.utils.subTitle
import com.example.musicplayersam.viewmodel.MusicControllerViewModel
import kotlinx.android.synthetic.main.content_bottom_controller.*
import kotlinx.android.synthetic.main.main_content.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import tech.soit.quiet.model.vo.Music
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.findAnnotation


/**
 *
 * the BaseActivity of this application
 *
 * use [LayoutId] annotation to bind a layout to activity
 *
 * use [EnableBottomController] to enable bottom controller for this activity
 *
 */
abstract class BaseActivity : AppCompatActivity(), CoroutineScope {

    private val controllerViewModel by lazy { MusicControllerViewModel() }

    private lateinit var job: Job

    @ColorInt
    var colorPrimary: Int = AppContext.attrValue(R.attr.colorPrimary)

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreate(savedInstanceState: Bundle?) {
        checkTest()
        super.onCreate(savedInstanceState)
        job = Job()

        //inject layout for annotation
        val isInjectLayout = this::class.findAnnotation<DisableLayoutInject>() == null
        val layoutId = this::class.java.getAnnotation(LayoutId::class.java)
        if (isInjectLayout && layoutId != null) {
            setContentView(layoutId.value)
        }

        if (enableBottomController()) {
            //make bottom controller interchangeable
            //listenBottomControllerEvent()
        }

        log {
            "create ${this::class.java.simpleName} " +
                    "layoutId :${layoutId?.value} , enableBottomController : ${enableBottomController()}"
        }
    }

    /**
     *  check for test , if is in test mode, will replace [viewModelFactory]
     */
    private fun checkTest() {
        val isTest = intent.getBooleanExtra("isTest", false)
        if (!isTest) {
            return
        }
        val rule = Class.forName("tech.soit.quiet.utils.test.BaseActivityTestRule").kotlin
        val objectInstance = rule.companionObjectInstance ?: return
        val objectClass = rule.companionObject ?: return
        objectClass.declaredFunctions.find { it.name == "injectActivity" }?.call(objectInstance, this)
    }

    /**
     * is should init bottom controller for this activity or not
     */
    protected open fun enableBottomController(): Boolean {
        val annotation = this::class.annotations.firstOrNull { it is EnableBottomController }
        return annotation != null
    }

    protected fun listenBottomControllerEvent() {
        controllerViewModel.playingMusic.observe(this, Observer { playing ->
            TransitionManager.beginDelayedTransition(root)
            if (playing == null) {
                bottomControllerLayout.isGone = true
            } else {
                bottomControllerLayout.isVisible = true
                updateBottomController(playing)
            }
        })
        controllerViewModel.playerState.observeNonNull(this) { state ->
            if (state == IMediaPlayer.PLAYING) {
                controllerPauseOrPlay.setImageResource(R.drawable.ic_pause_black_24dp)
                controllerPauseOrPlay.contentDescription = string(R.string.pause)
            } else {
                controllerPauseOrPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp)
                controllerPauseOrPlay.contentDescription = string(R.string.play)
            }
        }
        bottomControllerLayout.setOnClickListener {
            startActivity(Intent(this, MusicPlayerActivity::class.java))
        }
        controllerPlaylist.setOnClickListener {
           // PlayingPlaylistDialog.getInstance().show(supportFragmentManager, "PlayingPlaylist")
        }
        controllerPauseOrPlay.setOnClickListener {
            controllerViewModel.pauseOrPlay()
        }
    }

    /**
     * update BottomController UI
     */
    private fun updateBottomController(playing: Music) {
        //更新音乐信息
        musicTitle.text = playing.getTitle()
        musicSubTitle.text = playing.subTitle

        val picUri = playing.getAlbum().getCoverImageUrl()
        if (picUri != null) {
            ImageLoader.with(this).load(picUri).into(artWork)
        } else {
            artWork.setImageDrawable(ColorDrawable(attrValue(R.attr.colorPrimary)))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}