package com.example.bilibilikotlin.module.app.video

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.adapter.app.video.CommentAdapter
import com.example.bilibilikotlin.base.BaseInjectFragment
import com.example.bilibilikotlin.bean.app.video.MulComment
import com.example.bilibilikotlin.mvp.contract.app.video.CommentContract
import com.example.bilibilikotlin.mvp.presenter.app.video.CommentPresenter
import kotlinx.android.synthetic.main.fragment_comment.*

class CommentFragment : BaseInjectFragment<CommentPresenter>(), CommentContract.View {


    private var mAdapter: CommentAdapter? = null
    private val mList = mutableListOf<MulComment>()

    override fun getLayoutId(): Int = R.layout.fragment_comment

    override fun initInject() {
        fragmentComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun loadData() {
        mPresenter.getCommentData()
    }


    override fun initWidget() {
        initRecyclerView()
    }

    override fun initRecyclerView() {
        mAdapter = CommentAdapter(mList)
        recycler.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(mContext)
        recycler.layoutManager = layoutManager
        recycler.adapter = mAdapter
    }

    override fun showComment(mulComments: List<MulComment>) {
        mList.addAll(mulComments)
        finishTask()
    }

    override fun finishTask() {
        mAdapter?.notifyDataSetChanged()
    }

    companion object {

        fun newInstance(): CommentFragment {
            return CommentFragment()
        }
    }
}