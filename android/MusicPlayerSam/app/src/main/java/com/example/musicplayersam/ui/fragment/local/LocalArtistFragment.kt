package com.example.musicplayersam.ui.fragment.local

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayersam.R
import com.example.musicplayersam.ui.fragment.base.BaseFragment
import com.example.musicplayersam.utils.*
import com.example.musicplayersam.viewmodel.LocalMusicViewModel
import me.drakeet.multitype.MultiTypeAdapter

/**
 *
 * display local artist list
 *
 * @author : summer
 * @date : 18-9-1
 */
class LocalArtistFragment : BaseFragment() {


    private val viewModel by lazy { LocalMusicViewModel() }

    private val adapter = MultiTypeAdapter()
        .withBinder(AItemViewBinder(onClick = this::onArtistItemClicked))
        .withEmptyBinder()
        .withLoadingBinder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.allArtists.observe(this, Observer { artists ->
            when {
                artists == null -> adapter.submit(listOf(Loading))
                artists.isEmpty() -> adapter.submit(listOf(Empty))
                else -> adapter.submit(artists.map { AItem(it.getName(), "") })
            }
        })
    }

    override fun onCreateView2(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val recyclerView = RecyclerView(inflater.context)
        recyclerView.id = R.id.recyclerView
        return recyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = (view as ViewGroup).get(0) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapter
    }

    /**
     * callback when item clicked
     */
    private fun onArtistItemClicked(position: Int) {
//        val artist = adapter.items[position] as Artist
//        val intent = Intent(context, LocalMusicListActivity::class.java)
//        intent.putExtra(ARG_TYPE, TYPE_ARTIST)
//        intent.putExtra(ARG_OBJ, artist as Parcelable)
//        startActivity(intent)
    }

}