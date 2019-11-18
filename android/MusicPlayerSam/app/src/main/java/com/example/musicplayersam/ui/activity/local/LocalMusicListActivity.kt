package com.example.musicplayersam.ui.activity.local

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.activity.base.BaseActivity
import com.example.musicplayersam.ui.activity.local.viewmodel.LocalMusicListViewModel
import com.example.musicplayersam.ui.item.MusicItemViewBinder
import com.example.musicplayersam.utils.*
import com.example.musicplayersam.utils.annotation.EnableBottomController
import com.example.musicplayersam.utils.annotation.LayoutId
import com.example.musicplayersam.utils.component.log
import kotlinx.android.synthetic.main.activity_local_music_list.*
import me.drakeet.multitype.MultiTypeAdapter
import tech.soit.quiet.model.vo.Album
import tech.soit.quiet.model.vo.Artist
import tech.soit.quiet.model.vo.Music

/**
 * an activity which display a music list for Local
 */
@EnableBottomController
@LayoutId(R.layout.activity_local_music_list)
class LocalMusicListActivity : BaseActivity() {

    companion object {

        const val TYPE_ARTIST = 0

        const val TYPE_ALBUM = 1

        /**
         * the type of this music list
         *
         * could be [TYPE_ARTIST] or [TYPE_ALBUM]
         */
        const val ARG_TYPE = "arg_type"

        /**
         * this object determined by [ARG_TYPE]
         * if [ARG_TYPE] value is [TYPE_ARTIST] , it will be [Artist];
         * if value is [TYPE_ALBUM], it will be [Album]
         */
        const val ARG_OBJ = "arg_obj"

    }

    private val viewModel by lazy  { LocalMusicListViewModel() }

    private val adapter = MultiTypeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //check arguments
        val type = intent.getIntExtra(ARG_TYPE, -1)

        if (type != TYPE_ALBUM && type != TYPE_ARTIST) {
            throw IllegalStateException("ARG_TYPE must be one of TYPE_ALBUM($TYPE_ALBUM) or TYPE_ARTIST($TYPE_ARTIST) , current is $type")
        }
        val obj = intent.getParcelableExtra<Parcelable>(ARG_OBJ) ?: error("ARG_OBJ can not be null")

        val listLiveData: LiveData<List<Music>>
        val token: String
        val title: String

        if (type == TYPE_ALBUM) {
            title = (obj as Album).getName()
            listLiveData = viewModel.getMusicListByAlbum(obj)
            token = "local_artist_%s".format(obj.getName())
        } else {
            title = (obj as Artist).getName()
            listLiveData = viewModel.getMusicListByArtist(obj)
            token = "local_album_%s".format(obj.getName())
        }

        //init view
        adapter.withEmptyBinder()
            .withLoadingBinder()
            .withBinder(
                MusicItemViewBinder(
                token, this::onMusicItemClicked
            )
            )

        recyclerView.adapter = adapter

        toolbar.title = title
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        //observe data
        listLiveData.observe(this, Observer { list ->
            when {
                list == null -> adapter.setLoading()
                list.isEmpty() -> adapter.setEmpty()
                else -> adapter.submit(list)
            }
        })

    }

    private fun onMusicItemClicked(view: View, music: Music) {
        log { "on music item clicked" }
    }

}