package com.example.hmplayer.ui.fragment


import com.example.hmplayer.adapter.MvListAdapter
import com.example.hmplayer.base.BaseListAdapter
import com.example.hmplayer.base.BaseListFragment
import com.example.hmplayer.base.BaseListPresenter
import com.example.hmplayer.model.MvPagerBean
import com.example.hmplayer.model.VideoPlayBean
import com.example.hmplayer.model.VideosBean
import com.example.hmplayer.presenter.impl.MvListPresenterImpl
import com.example.hmplayer.ui.activity.VideoPlayerActivity
import com.example.hmplayer.widget.MvItemView
import org.jetbrains.anko.support.v4.startActivity

class MvPagerFragment : BaseListFragment<List<VideosBean>, VideosBean, MvItemView>(){

    var code: String? = null

    override fun init() {
        code = arguments?.getString("args")
    }


    override fun getSpecialAdapter(): BaseListAdapter<VideosBean, MvItemView> {
        return MvListAdapter()
    }

    override fun getList(response: List<VideosBean>?): List<VideosBean>? {
        return response
    }

    override fun getSpecialPresenter(): BaseListPresenter {
         return  return MvListPresenterImpl(code!!, this)
    }

    override fun setListener() {
        // 设置条目点击事件
        adapter.setMyListener {
            startActivity<VideoPlayerActivity>("item" to VideoPlayBean(1, "big_buck_bunny", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"))
        }
    }

//    // 在fragment创建时传递数据不能通过构造函数
//    var name: String? = null
//
//    companion object {
//
//        fun getInstance(title: String?): MvPagerFragment
//        {
//            val fragment = MvPagerFragment()
//            val bundle = Bundle()
//            bundle.putString("args", title)
//            fragment.arguments = bundle
//            return fragment
//        }
//    }
//
//    override fun init() {
//        name = arguments?.getString("args")
//    }
//
//    override fun initView(): View? {
//        val tv = TextView(activity)
//        tv.gravity = Gravity.CENTER
//        tv.setTextColor(Color.RED)
//        tv.text = name
//        return tv
//    }

}