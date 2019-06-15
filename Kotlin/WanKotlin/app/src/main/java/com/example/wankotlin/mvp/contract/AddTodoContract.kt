package com.example.wankotlin.mvp.contract

import com.example.wankotlin.base.IModel
import com.example.wankotlin.base.IPresenter
import com.example.wankotlin.base.IView
import com.example.wankotlin.mvp.model.bean.HttpResult
import io.reactivex.Observable

interface AddTodoContract {

    interface View : IView {

        fun showAddTodo(success: Boolean)

        fun showUpdateTodo(success: Boolean)

        fun getType(): Int
        fun getCurrentDate(): String
        fun getTitle(): String
        fun getContent(): String
        fun getStatus(): Int
        fun getItemId(): Int
        fun getPriority(): String

    }

    interface Presenter : IPresenter<View> {

        fun addTodo()

        fun updateTodo(id: Int)

    }

    interface Model : IModel {

        fun addTodo(map: MutableMap<String, Any>): Observable<HttpResult<Any>>

        fun updateTodo(id: Int, map: MutableMap<String, Any>): Observable<HttpResult<Any>>

    }


}