package com.example.waneye.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.waneye.R
import com.example.waneye.mvp.model.bean.HomeBean
import com.example.waneye.mvp.model.bean.VideoBean
import com.example.waneye.utils.ImageLoadUtils

class HomeAdatper(context: Context, list: MutableList<HomeBean.IssueListBean.ItemListBean>?) : RecyclerView.Adapter<HomeAdatper.HomeViewHolder>() {

    var context : Context? = null;
    var list: MutableList<HomeBean.IssueListBean.ItemListBean>? = null
    var inflater : LayoutInflater? = null
    init {
        this.context = context
        this.list = list
        this.inflater = LayoutInflater.from(context)
    }

    override fun getItemCount(): Int {
        return list?.size ?:0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(inflater?.inflate(R.layout.item_home,parent,false)!!, context!!)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val bean = list?.get(position)
        bean.run {
            val title = this?.data?.title
            val category = this?.data?.category
            val minute = this?.data?.duration?.div(60)
            val second = this?.data?.duration?.minus((minute?.times(60)) as Long )
            var realMinute : String
            var realSecond : String

            if (minute!! < 10) {
                realMinute = "0"+minute
            } else {
                realMinute = minute.toString()
            }

            if (second!! < 10) {
                realSecond = "0"+second
            } else {
                realSecond = second.toString()
            }

            val playUrl = this?.data?.playUrl
            val photo = this?.data?.cover?.feed
            val author = this?.data?.author

            ImageLoadUtils.display(context!!, holder?.iv_photo, photo as String)
            holder?.tv_title?.text = title
            holder?.tv_detail?.text = "发布于 $category / $realMinute:$realSecond"
            if (author != null) {
                ImageLoadUtils.display(context!!,holder?.iv_user,author.icon as String)
            } else {
                holder?.iv_user?.visibility = View.GONE
            }

            holder?.itemView?.setOnClickListener {
//                //跳转视频详情页
//                val intent : Intent = Intent(context,VideoDetailActivity::class.java)
//                val desc = this?.data?.description
//                val duration = this?.data?.duration
//                val playUrl = this?.data?.playUrl
//                val blurred = this?.data?.cover?.blurred
//                val collect = this?.data?.consumption?.collectionCount
//                val share = this?.data?.consumption?.shareCount
//                val reply = this?.data?.consumption?.replyCount
//                val time = System.currentTimeMillis()
//                val videoBean  = VideoBean(photo,title,desc,duration,playUrl,category,blurred,collect ,share ,reply,time)
//                val url = SPUtils.getInstance(context!!,"beans").getString(playUrl!!)
//                if (url.equals("")) {
//                    var count = SPUtils.getInstance(context!!,"beans").getInt("count")
//                    if (count != -1) {
//                        count = count.inc()
//                    } else {
//                        count = 1
//                    }
//                    SPUtils.getInstance(context!!,"beans").put("count",count)
//                    SPUtils.getInstance(context!!,"beans").put(playUrl!!,playUrl)
//                    ObjectSaveUtils.saveObject(context!!,"bean$count",videoBean)
//                }
//                intent.putExtra("data",videoBean as Parcelable)
//                context?.let { context -> context.startActivity(intent) }
            }
        }
    }

    class HomeViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        var tv_detail : TextView? = null
        var tv_title : TextView? = null
        var tv_time : TextView? = null
        var iv_photo : ImageView? = null
        var iv_user : ImageView? = null
        init {
            tv_detail = itemView?.findViewById(R.id.tv_detail) as TextView?
            tv_title = itemView?.findViewById(R.id.tv_title) as TextView?
            iv_photo = itemView?.findViewById(R.id.iv_photo) as ImageView?
            iv_user =  itemView?.findViewById(R.id.iv_user) as ImageView?
            tv_title?.typeface = Typeface.createFromAsset(context?.assets, "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF")

        }
    }
}