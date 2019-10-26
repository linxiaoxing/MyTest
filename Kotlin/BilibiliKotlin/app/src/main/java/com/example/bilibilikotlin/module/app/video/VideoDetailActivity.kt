package com.example.bilibilikotlin.module.app.video

import android.content.Intent
import android.view.Menu
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.OvershootInterpolator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.bilibilikotlin.R
import com.example.bilibilikotlin.bean.app.video.VideoDetail
import com.example.bilibilikotlin.bean.app.video.VideoDetailComment
import com.example.bilibilikotlin.event.Event
import com.example.bilibilikotlin.module.region.BaseRegionActivity
import com.example.bilibilikotlin.mvp.contract.app.VideoDetailContract
import com.example.bilibilikotlin.mvp.presenter.app.video.VideoDetailPresenter
import com.example.bilibilikotlin.rx.RxBus
import com.example.bilibilikotlin.widget.StatusBarUtil
import kotlinx.android.synthetic.main.activity_video_detail.*
import kotlinx.android.synthetic.main.activity_video_detail.app_bar
import kotlinx.android.synthetic.main.activity_video_detail.fab
import kotlinx.android.synthetic.main.activity_video_detail.iv_video_preview
import kotlinx.android.synthetic.main.activity_video_detail1.*
import javax.annotation.Nullable

class VideoDetailActivity : BaseRegionActivity<VideoDetailPresenter, Nullable>(), VideoDetailContract.View {


    private lateinit var mVideoDetail: VideoDetail.DataBean
    private lateinit var mVideoDetailComment: VideoDetailComment.DataBean

    private var state: CollapsingToolbarLayoutState? = null

    private enum class CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    override fun getLayoutId(): Int = R.layout.activity_video_detail1

    override fun showVideoDetail(videoDetail: VideoDetail.DataBean) {
        mVideoDetail = videoDetail

    }

    override fun showVideoDetailComment(videoDetailComment: VideoDetailComment.DataBean) {
        mVideoDetailComment = videoDetailComment
        finishTask()
    }

    override fun loadData() {
        mPresenter.getVideoDetailData()
    }

    override fun initInject() {
        activityComponent.inject(this)
    }

    override fun initPresenter() {
        mPresenter.attachView(this)
    }

    override fun finishTask() {
        //设置图片
        Glide.with(mContext)
            .load<Any>(mVideoDetail.pic)
            .centerCrop()
            .placeholder(R.drawable.bili_default_image_tv)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .dontAnimate()
            .into(iv_video_preview)
        super.finishTask()
        initEvent()
    }

    override fun initEvent() {
        val videoDetailEvent = Event.VideoDetailEvent()
        videoDetailEvent.videoDetail = mVideoDetail

        val videoDetailCommentEvent = Event.VideoDetailCommentEvent()
        videoDetailCommentEvent.videoDetailComment = mVideoDetailComment

        RxBus.post(videoDetailEvent)
        RxBus.post(videoDetailCommentEvent)
    }

    override fun initTitle() {
        mTitles.add("简介")
        mTitles.add("评论(${mVideoDetailComment.page.acount})")

    }

    override fun initFragment() {
        mFragment.add(SummaryFragment.newInstance())
        mFragment.add(CommentFragment.newInstance())

    }

    override fun initViewPager() {
        super.initViewPager()
        setCurrentItem(0)
    }

    override fun initToolbar() {
        //mToolbar.setNavigationIcon(R.drawable.ic_clip_back_white);
        super.initToolbar()
        mToolbar?.title = ""
    }

    override fun initStatusBar() {
        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return false
    }

    /**
     * 设置FAB动画
     * @param target
     */
    private fun setViewsTranslation(target: Int) {
        fab.translationY = target.toFloat()
        if (target == 0) {
            fab.animate().scaleX(1f).scaleY(1f)
                .setInterpolator(OvershootInterpolator())
                .start()
            fab.isClickable = true
        } else if (target < 0) {
            fab.animate().scaleX(0f).scaleY(0f)
                .setInterpolator(AccelerateInterpolator())
                .start()
            fab.isClickable = false
        }
    }

    override fun initWidget() {
        super.initWidget()
        fab.setOnClickListener {
            startActivity(Intent(this, VideoPlayerActivity::class.java))
        }
        // initFAB();
        visible(pw_loading)
        initAppBar()
    }

    private fun initFAB() {
        // mFab.setTranslationY(-getResources().getDimension(R.dimen.dp32));
    }

    private fun initAppBar() {
        // TODO
        //app_bar.addOnOffsetChangedListener { _, verticalOffset -> setViewsTranslation(verticalOffset) }
//        app_bar.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
//            if (verticalOffset == 0) {
//                if (state != CollapsingToolbarLayoutState.EXPANDED) {
//                    state = CollapsingToolbarLayoutState.EXPANDED//修改状态标记为展开
//                    tv_player.visibility = View.GONE
//                    tv_av.visibility = View.VISIBLE
//                }
//            } else if (Math.abs(verticalOffset) >= appBarLayout.totalScrollRange) {
//                if (state != CollapsingToolbarLayoutState.COLLAPSED) {
//                    tv_player.visibility = View.VISIBLE
//                    tv_av.visibility = View.GONE
//                }
//            } else {
//                tv_player.visibility = View.GONE
//                tv_av.visibility = View.VISIBLE
//            }
//        }
    }

    override fun showError(msg: String) {
        super.showError(msg)
        gone(pw_loading)

    }

    override fun complete() {
        super.complete()
        gone(pw_loading)
    }

}