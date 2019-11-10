package com.example.musicplayersam.ui.fragment.home

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RawRes
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.fragment.base.BaseFragment
import com.example.musicplayersam.ui.fragment.home.cloud.PlayListViewBinder
import com.example.musicplayersam.ui.fragment.home.viewmodel.MainMusicViewModel
import com.example.musicplayersam.ui.view.CircleOutlineProvider
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.ImageLoader
import com.example.musicplayersam.utils.component.log
import com.example.musicplayersam.utils.component.support.color
import com.example.musicplayersam.utils.component.support.dimen
import com.example.musicplayersam.utils.submit
import com.example.musicplayersam.utils.withBinder
import com.example.musicplayersam.utils.withEmptyBinder
import com.example.musicplayersam.utils.withLoadingBinder
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.content_main_music_user_info.*
import kotlinx.android.synthetic.main.fragment_main_music.*
import kotlinx.android.synthetic.main.item_main_navigation.view.*
import kotlinx.coroutines.launch

import me.drakeet.multitype.MultiTypeAdapter
import tech.soit.quiet.model.po.NeteasePlayListDetail
import tech.soit.quiet.model.vo.PlayListDetail
import tech.soit.quiet.model.vo.User
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * main Fragment of music
 */
@LayoutId(R.layout.fragment_main_music)
class MainMusicFragment : BaseFragment() {

    companion object {

        private const val REQUEST_LOGIN = 1203

    }

    private val mainMusicViewMode by lazy { MainMusicViewModel() }

    private val neteaseRepository get() = mainMusicViewMode.getNeteaseRepository()

    private lateinit var adapter: MultiTypeAdapter

    private var rangeCreated = IntRange(0, 0)
    private var rangeCollection = IntRange(0, 0)
    private var positionCollectionStart = 0

    private var isLogin = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init navigation items
        initNavigation()

        //init recycler view
        adapter = MultiTypeAdapter()
            .withBinder(PlayListViewBinder())
            .withEmptyBinder()
            .withLoadingBinder()
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            private var totalY = 0

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                totalY += dy
                val offset = totalY.toFloat() / (rangeCollection.last - recyclerView.height)
                tabLayoutPlayLists.setScrollPosition(0, offset, true)
            }
        })
        tabLayoutPlayLists.touchables.forEach { it.isClickable = false }

        loadData()
    }

    private fun initNavigation() {
        imageUserAvatar.outlineProvider = CircleOutlineProvider()
        imageUserAvatar.clipToOutline = true

        layoutUserInfo.setOnClickListener {
            if (!isLogin) {
               // startActivityForResult(Intent(requireContext(), LoginActivity::class.java), REQUEST_LOGIN)
            } else {
                log { "has been login" }
            }
        }

        with(navLayoutLocal) {
            imageIcon.setImageResource(R.drawable.ic_music_note_black_24dp)
            textTitle.setText(R.string.nav_local_music)
            setOnClickListener {
                // startActivity(Intent(requireActivity(), LocalMusicActivity::class.java))
            }
        }

        with(navLayoutHistory) {
            imageIcon.setImageResource(R.drawable.ic_history_black_24dp)
            textTitle.setText(R.string.nav_history)
            setOnClickListener {
                // startActivity(Intent(requireActivity(), LatestPlayListActivity::class.java))
            }
        }

        with(navLayoutDownload) {
            imageIcon.setImageResource(R.drawable.ic_file_download_black_24dp)
            textTitle.setText(R.string.nav_download)
        }

        with(navLayoutCollection) {
            imageIcon.setImageResource(R.drawable.ic_collections_black_24dp)
            textTitle.setText(R.string.nav_collection)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_LOGIN && resultCode == Activity.RESULT_OK) {
            loadData()
        }
    }

    private fun loadData() {
        launch {
//            val user = neteaseRepository.getLoginUser()
//            checkUser(user)
//            user ?: return@launch

            val playLists: List<PlayListDetail>
            playLists = readMarkdown(R.raw.user_playlist)
//            try {
//                playLists = neteaseRepository.getUserPlayerList(user.getId())
//                computePlayListRange(playLists, user.getId())
//            } catch (e: Exception) {
//                Toast.makeText(requireContext(), e.message ?: "error", Toast.LENGTH_SHORT).show()
//                return@launch
//            }
            adapter.submit(playLists)
        }
    }

    private fun readMarkdown(@RawRes rawId: Int): List<PlayListDetail> {
        val stringBuilder = StringBuilder()
        BufferedReader(InputStreamReader(resources.openRawResource(rawId))).use {
            var line = it.readLine()
            while (line != null) {
                stringBuilder.append(line).append('\n')
                line = it.readLine()
            }
        }
        val response = Gson().fromJson(stringBuilder.toString().reader(), JsonObject::class.java)
        val array = response["playlist"].asJsonArray
        return array.map {
            NeteasePlayListDetail(it as JsonObject)
        }
    }

    private fun computePlayListRange(playLists: List<PlayListDetail>, userId: Long) {
        val createdCount = playLists.count { it.getCreator().getId() == userId }
        positionCollectionStart = createdCount //reset started position of collection
        val height = dimen(R.dimen.height_item_play_list).toInt()
        rangeCreated = 0..(createdCount * height)
        rangeCollection = (createdCount * height)..(playLists.size * height)
    }

    /**
     * check if user has been login
     */
    private fun checkUser(user: User?) {
        isLogin = user != null
        if (user == null) {
            imageUserAvatar.setImageDrawable(ColorDrawable(color(R.color.color_gray)))
            textUserNickname.setText(R.string.user_not_login)
        } else {
            ImageLoader.with(this).load(user.getAvatarUrl()).into(imageUserAvatar)
            textUserNickname.text = user.getNickName()
        }
    }


}