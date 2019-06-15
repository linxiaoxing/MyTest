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
import com.example.waneye.mvp.model.bean.HotBean
import com.example.waneye.mvp.model.bean.VideoBean
import com.example.waneye.utils.ImageLoadUtils

class RankAdapter(context: Context, list: ArrayList<HotBean.ItemListBean.DataBean>) : RecyclerView.Adapter<RankAdapter.RankViewHolder>() {

    var context: Context? = null;
    var list: ArrayList<HotBean.ItemListBean.DataBean>? = null
    var inflater: LayoutInflater? = null

    init {
        this.context = context
        this.list = list
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        return RankViewHolder(inflater?.inflate(R.layout.item_rank, parent, false)!!, context!!)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        val photoUrl : String? = list?.get(position)?.cover?.feed
        photoUrl?.let { ImageLoadUtils.display(context!!, holder?.iv_photo, it) }
        val title : String? = list?.get(position)?.title
        holder?.tv_title?.text = title
        val category = list?.get(position)?.category
        val duration = list?.get(position)?.duration
        val minute =duration?.div(60)
        val second = duration?.minus((minute?.times(60)) as Long )
        val realMinute : String
        val realSecond : String
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
        holder?.tv_time?.text = "$category / $realMinute'$realSecond''"
        holder?.itemView?.setOnClickListener {
            //跳转视频详情页
//            val intent : Intent = Intent(context, VideoDetailActivity::class.java)
//            val desc = list?.get(position)?.description
//            val playUrl = list?.get(position)?.playUrl
//            val blurred = list?.get(position)?.cover?.blurred
//            val collect = list?.get(position)?.consumption?.collectionCount
//            val share = list?.get(position)?.consumption?.shareCount
//            val reply = list?.get(position)?.consumption?.replyCount
//            val time = System.currentTimeMillis()
//            val videoBean  = VideoBean(photoUrl,title,desc,duration,playUrl,category,blurred,collect ,share ,reply,time)
//            val url = SPUtils.getInstance(context!!,"beans").getString(playUrl!!)
//            if(url.equals("")){
//                val count = SPUtils.getInstance(context!!,"beans").getInt("count")
//                if(count!=-1){
//                    count = count.inc()
//                }else{
//                    count = 1
//                }
//                SPUtils.getInstance(context!!,"beans").put("count",count)
//                SPUtils.getInstance(context!!,"beans").put(playUrl!!,playUrl)
//                ObjectSaveUtils.saveObject(context!!,"bean$count",videoBean)
//            }
//            intent.putExtra("data",videoBean as Parcelable)
//            context?.let { context -> context.startActivity(intent) }
        }
    }


    class RankViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        var iv_photo: ImageView = itemView?.findViewById(R.id.iv_photo) as ImageView
        var tv_title: TextView = itemView?.findViewById(R.id.tv_title) as TextView
        var tv_time: TextView = itemView?.findViewById(R.id.tv_time) as TextView
        init {
            tv_title?.typeface = Typeface.createFromAsset(context?.assets, "fonts/FZLanTingHeiS-L-GB-Regular.TTF")

        }
    }
}