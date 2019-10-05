package com.example.gsykotlin.di

import android.app.Application
import com.example.gsykotlin.GSYGithubApplication
import com.example.gsykotlin.common.db.RealmFactory
import com.example.gsykotlin.common.net.RetrofitFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * App级别注入
 */

@Singleton
@Component(modules = [
    // 用于绑定扩展的组件，如v4
    // 我们使用的是支持库（v4库）的 Fragment
    // 接入后可以使用  AndroidInjection.inject(activity) 和  AndroidSupportInjection.inject(f)
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindModule::class
])
interface AppComponent {
    /**
     * 通过 @Component.Builder 增加builder方法，提供Application 注入方法。
     */
    @Component.Builder
    interface Builder {
        //@BindsInstance注解的作用，只能在 Component.Builder 中使用
        //创建 Component 的时候绑定依赖实例
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
    fun inject(gsyGithubApplication: GSYGithubApplication)
}

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {
        return RetrofitFactory.instance.retrofit
    }

    @Singleton
    @Provides
    fun providerRealmFactory(): RealmFactory {
        return RealmFactory.instance
    }
}