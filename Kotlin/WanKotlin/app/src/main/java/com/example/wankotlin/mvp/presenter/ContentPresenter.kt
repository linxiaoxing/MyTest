package com.example.wankotlin.mvp.presenter

import com.example.wankotlin.mvp.contract.ContentContract
import com.example.wankotlin.mvp.model.ContentModel

class ContentPresenter : CommonPresenter<ContentContract.Model, ContentContract.View>(), ContentContract.Presenter {

    override fun createModel(): ContentContract.Model? = ContentModel()

}