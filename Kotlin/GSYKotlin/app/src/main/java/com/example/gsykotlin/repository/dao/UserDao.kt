package com.example.gsykotlin.repository.dao

import android.app.Application
import com.example.gsykotlin.common.db.FlatMapRealmSaveResult
import com.example.gsykotlin.common.db.FlatTransactionInterface
import com.example.gsykotlin.common.db.ReceivedEvent
import com.example.gsykotlin.common.utils.GsonUtils
import com.example.gsykotlin.model.bean.Event
import io.realm.RealmQuery
import io.realm.RealmResults
import retrofit2.Response
import javax.inject.Inject

/**
 * 用户相关数据库操作
 */
class UserDao @Inject constructor(private val application: Application) {


    /**
     * 保存当前用户接收到的事件
     */
    fun saveReceivedEventDao(response: Response<ArrayList<Event>>, needSave: Boolean) {
        FlatMapRealmSaveResult(response, ReceivedEvent::class.java, object :
            FlatTransactionInterface<ReceivedEvent> {
            override fun query(q: RealmQuery<ReceivedEvent>): RealmResults<ReceivedEvent> {
                return q.findAll()
            }

            override fun onTransaction(targetObject: ReceivedEvent?) {
                val data = GsonUtils.toJsonString(response.body())
                targetObject?.data = data
            }
        }, needSave)
    }

}
