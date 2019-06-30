package com.example.waneye.ui.fragment

import android.content.Intent
import com.example.waneye.R
import com.example.waneye.adapter.FindAdapter
import com.example.waneye.mvp.contract.FindContract
import com.example.waneye.mvp.model.bean.FindBean
import com.example.waneye.mvp.presenter.FindPresenter
import kotlinx.android.synthetic.main.find_fragment.*

class FindFragment : BaseFragment(), FindContract.View {

    private val mPresenter: FindPresenter by lazy {
        FindPresenter(context!!, this)
    }

    private val mAdapter: FindAdapter by lazy {
        FindAdapter(context!!, mList)
    }
    var mList: MutableList<FindBean> = mutableListOf<FindBean>()

    override fun setData(beans: MutableList<FindBean>) {
        mAdapter?.mList = beans
        mList = beans
        mAdapter?.notifyDataSetChanged()
    }

    override fun getLayoutResources(): Int {
        return R.layout.find_fragment
    }

    override fun initView() {
        mPresenter?.start()
        gv_find.adapter = mAdapter
        gv_find.setOnItemClickListener { parent, view, position, id ->
            var bean = mList?.get(position)
            var name = bean?.name
//            var intent : Intent = Intent(context,FindDetailActivity::class.java)
//            intent.putExtra("name",name)
//            startActivity(intent)

        }
    }
}