package com.example.gsykotlin.repository.dao

import android.app.Application
import com.example.gsykotlin.common.db.FlatMapRealmReadList
import com.example.gsykotlin.common.db.FlatRealmReadConversionInterface
import com.example.gsykotlin.common.db.RealmFactory
import com.example.gsykotlin.common.db.TrendRepository
import com.example.gsykotlin.common.utils.GsonUtils
import com.example.gsykotlin.model.bean.TrendingRepoModel
import com.example.gsykotlin.model.conversion.ReposConversion
import io.reactivex.Observable
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

/**
 * 仓库相关数据库操作
 * Created by guoshuyu
 * Date: 2018-11-07
 */
class ReposDao @Inject constructor(private val application: Application) {

    /**
     * 获取趋势数据
     */
    fun getTrendDao(language: String, since: String): Observable<ArrayList<Any>> {
        return RealmFactory.getRealmObservable()
            .map {
                val list = FlatMapRealmReadList(
                    it,
                    object : FlatRealmReadConversionInterface<TrendingRepoModel, TrendRepository> {
                        override fun query(realm: Realm): RealmResults<TrendRepository> {
                            return realm.where(TrendRepository::class.java)
                                .equalTo("languageType", language).equalTo("since", since).findAll()
                        }

                        override fun onJSON(t: TrendRepository): List<TrendingRepoModel> {
                            return GsonUtils.parserJsonToArrayBeans(
                                t.data!!,
                                TrendingRepoModel::class.java
                            )
                        }

                        override fun onConversion(t: TrendingRepoModel): Any {
                            return ReposConversion.trendToReposUIModel(t)
                        }
                    })
                list
            }
    }
}