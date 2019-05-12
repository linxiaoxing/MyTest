package com.example.ordercenter.injection.component

import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.ordercenter.injection.module.ShipAddressModule
import com.example.ordercenter.ui.act.ShipAddressActivity
import com.example.ordercenter.ui.act.ShipAddressEditActivity
import dagger.Component

/*
    收货人信息Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ShipAddressModule::class))
interface ShipAddressComponent {
    fun inject(activity: ShipAddressEditActivity)
    fun inject(activity: ShipAddressActivity)
}
