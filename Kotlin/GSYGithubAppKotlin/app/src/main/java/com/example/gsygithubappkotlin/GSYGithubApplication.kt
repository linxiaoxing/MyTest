package com.example.gsygithubappkotlin

import android.app.Activity
import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.alibaba.android.arouter.launcher.ARouter
import com.example.gsygithubappkotlin.common.db.RealmFactory
import com.example.gsygithubappkotlin.common.gsyimageloader.GSYImageLoaderManager
import com.example.gsygithubappkotlin.common.gsyimageloader.gsygiideloader.GSYGlideImageLoader
import com.example.gsygithubappkotlin.common.style.GSYIconfont
import com.example.gsygithubappkotlin.common.utils.CommonUtils
import com.example.gsygithubappkotlin.di.AppInjector
import com.mikepenz.iconics.Iconics
import com.tencent.bugly.crashreport.CrashReport
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.realm.Realm
import javax.inject.Inject
import kotlin.properties.Delegates
import com.mikepenz.materialdrawer.util.AbstractDrawerImageLoader
import com.mikepenz.materialdrawer.util.DrawerImageLoader

class GSYGithubApplication : Application(), HasActivityInjector {

    companion object {
        var instance: GSYGithubApplication by Delegates.notNull()
    }

    /**
     * 分发Activity的注入
     *
     * 在Activity调用AndroidInjection.inject(this)时
     * 从Application获取一个DispatchingAndroidInjector<Activity>，并将activity传递给inject(activity)
     * DispatchingAndroidInjector通过AndroidInjector.Factory创建AndroidInjector
     */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        instance = this

        ///初始化路由
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }

        ARouter.init(this)

        //Application级别注入
        AppInjector.init(this)

        ///初始化图标库
        Iconics.init(applicationContext)
        Iconics.registerFont(GSYIconfont)

        ///初始化图片加载
        GSYImageLoaderManager.initialize(GSYGlideImageLoader(this))

        ///数据库
        Realm.init(this)
        RealmFactory.instance

        if (!BuildConfig.DEBUG) {
            ///bugly
            CrashReport.initCrashReport(applicationContext, "209f33d74f", false)
        }

        DrawerImageLoader.init(object : AbstractDrawerImageLoader() {

            override fun placeholder(ctx: Context): Drawable {
                return getDrawable(R.drawable.logo)
            }

            override fun placeholder(ctx: Context, tag: String?): Drawable {
                return getDrawable(R.drawable.logo)
            }
            override fun set(imageView: ImageView, uri: Uri, placeholder: Drawable, tag: String?) {
                CommonUtils.loadUserHeaderImage(imageView, uri.toString())
            }
        })
    }

    override fun activityInjector() = dispatchingAndroidInjector
}