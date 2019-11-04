package com.example.gsyplayersam.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.gsyplayersam.AutoPlayRecyclerViewActivity;
import com.example.gsyplayersam.DanmkuVideoActivity;
import com.example.gsyplayersam.DetailListPlayer;
import com.example.gsyplayersam.DetailPlayer;
import com.example.gsyplayersam.FragmentVideoActivity;
import com.example.gsyplayersam.ListVideoActivity;
import com.example.gsyplayersam.PlayActivity;
import com.example.gsyplayersam.R;
import com.example.gsyplayersam.RecyclerView2Activity;
import com.example.gsyplayersam.RecyclerViewActivity;
import com.example.gsyplayersam.ScrollingActivity;
import com.example.gsyplayersam.WebDetailActivity;

public class JumpUtils {


    /**
     * 跳转到视频播放
     *
     * @param activity
     * @param view
     */
    public static void goToVideoPlayer(Activity activity, View view) {

        Intent intent = new Intent(activity, PlayActivity.class);
        intent.putExtra(PlayActivity.TRANSITION, true);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Pair pair = new Pair<>(view, PlayActivity.IMG_TRANSITION);
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    activity, pair);
            ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
        } else {
            activity.startActivity(intent);
            activity.overridePendingTransition( R.anim.abc_fade_in, R.anim.abc_fade_out);
        }
    }

    /**
     * 跳转到视频列表
     *
     * @param activity
     */
    public static void goToVideoPlayer(Activity activity) {
        Intent intent = new Intent(activity, ListVideoActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
        ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
    }

    /**
            * 跳转到视频列表
     *
             * @param activity
     */
    public static void goToVideoRecyclerPlayer(Activity activity) {
        Intent intent = new Intent(activity, RecyclerViewActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
        ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
    }

    /**
     * 跳转到视频列表2
     *
     * @param activity
     */
    public static void goToVideoRecyclerPlayer2(Activity activity) {
        Intent intent = new Intent(activity, RecyclerView2Activity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
        ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
    }

    /**
     * 跳转到视频列表
     *
     * @param activity
     */
    public static void goToAutoVideoPlayer(Activity activity) {
        Intent intent = new Intent(activity, AutoPlayRecyclerViewActivity.class);
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity);
        ActivityCompat.startActivity(activity, intent, activityOptions.toBundle());
    }

    /**
     * 跳转到详情播放
     *
     * @param activity
     */
    public static void goToScrollDetailPlayer(Activity activity) {
        Intent intent = new Intent(activity, ScrollingActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到详情播放
     *
     * @param activity
     */
    public static void goToDetailPlayer(Activity activity) {
        Intent intent = new Intent(activity, DetailPlayer.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到详情播放
     *
     * @param activity
     */
    public static void goToDetailListPlayer(Activity activity) {
        Intent intent = new Intent(activity, DetailListPlayer.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到详情播放
     *
     * @param activity
     */
    public static void gotoWebDetail(Activity activity) {
        Intent intent = new Intent(activity, WebDetailActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到弹幕
     *
     * @param activity
     */
    public static void gotoDanmaku(Activity activity) {
        Intent intent = new Intent(activity, DanmkuVideoActivity.class);
        activity.startActivity(intent);
    }

    /**
     * 跳转到Fragment
     *
     * @param activity
     */
    public static void gotoFragment(Activity activity) {
        Intent intent = new Intent(activity, FragmentVideoActivity.class);
        activity.startActivity(intent);
    }
}
