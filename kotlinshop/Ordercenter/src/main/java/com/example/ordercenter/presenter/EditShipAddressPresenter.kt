package com.example.ordercenter.presenter

import com.example.chen.baselibrary.ext.excute
import com.example.chen.baselibrary.presenter.BasePresenter
import com.example.chen.baselibrary.rx.BaseSubscriber
import com.example.ordercenter.presenter.view.ShipAddressView
import com.example.ordercenter.service.ShipAddressService
import com.kotlin.order.data.protocol.ShipAddress
import com.kotlin.order.presenter.view.EditShipAddressView
import javax.inject.Inject

/*
    编辑收货人信息Presenter
 */
class EditShipAddressPresenter @Inject constructor() : BasePresenter<EditShipAddressView>() {

    @Inject
    lateinit var shipAddressService: ShipAddressService

    /*
        添加收货人信息
     */
    fun addShipAddress(shipUserName: String, shipUserMobile: String, shipAddress: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.addShipAddress(shipUserName, shipUserMobile, shipAddress).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onAddShipAddressResult(t)
            }
        }, lifecycleProvider)

    }

    /**
     *  修改收货人信息
     */
    fun editShipAddress(address: ShipAddress) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        shipAddressService.editShipAddress(address).excute(object : BaseSubscriber<Boolean>(mView) {
            override fun onNext(t: Boolean) {
                mView.onEditShipAddressResult(t)
            }
        }, lifecycleProvider)

    }
}
