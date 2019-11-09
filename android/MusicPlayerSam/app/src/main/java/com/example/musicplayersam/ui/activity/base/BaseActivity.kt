package com.example.musicplayersam.ui.activity.base

import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import com.example.musicplayersam.AppContext
import com.example.musicplayersam.R
import com.example.musicplayersam.utils.annotation.DisableLayoutInject
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.log
import com.example.musicplayersam.utils.component.support.attrValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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

    protected fun listenBottomControllerEvent() {}

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}