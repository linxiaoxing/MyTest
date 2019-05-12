package com.kotlin.pay.injection.component

import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.paysdk.ui.activity.CashRegisterActivity
import com.kotlin.pay.injection.module.PayModule
import dagger.Component

/*
    支付Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(PayModule::class)])
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}
