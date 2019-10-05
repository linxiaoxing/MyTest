package com.example.gsykotlin.repository

import android.app.Application
import com.example.gsykotlin.common.net.ResultCallBack
import com.example.gsykotlin.common.net.RetrofitFactory
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Issue相关数据获取
 */
class IssueRepository @Inject constructor(private val retrofit: Retrofit, private val application: Application, private val issueDao: IssueDao) {

    /**
     * issue 信息
     */
    fun getIssueInfo(
        userName: String,
        reposName: String,
        number: Int,
        resultCallBack: ResultCallBack<IssueUIModel>?
    ) {

        val dbService = issueDao.getIssueInfoDao(userName, reposName, number)
            .doOnNext {
                resultCallBack?.onCacheSuccess(it)
            }

        val issueService = retrofit.create(IssueService::class.java)
            .getIssueInfo(true, userName, reposName, number)
            .doOnNext {
                issueDao.saveIssueInfoDao(it, userName, reposName, number)
            }
            .flatMap {
                FlatMapResponse2Result(it)
            }.map {
                IssueConversion.issueToIssueUIModel(it)
            }.flatMap {
                FlatMapResult2Response(it)
            }


        val zipService = Observable.zip(dbService, issueService,
            BiFunction<IssueUIModel?, Response<IssueUIModel>, Response<IssueUIModel>> { _, remote ->
                remote
            })


        RetrofitFactory.executeResult(
            zipService,
            object : ResultTipObserver<IssueUIModel>(application) {
                override fun onSuccess(result: IssueUIModel?) {
                    resultCallBack?.onSuccess(result)
                }

                override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                    resultCallBack?.onFailure()
                }
            })
    }

}
