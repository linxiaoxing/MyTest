package com.kotlin.order.injection.component
import com.example.chen.baselibrary.injection.PerComponentScope
import com.example.chen.baselibrary.injection.component.ActivityComponent
import com.example.ordercenter.ui.act.OrderConfirmActivity
import com.example.ordercenter.ui.act.OrderDetailActivity
import com.example.ordercenter.ui.fragment.OrderFragment
import com.kotlin.order.injection.module.OrderModule
import dagger.Component
/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)],modules = [(OrderModule::class)])
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)
    fun inject(activity: OrderFragment)
    fun inject(activity: OrderDetailActivity)

}
