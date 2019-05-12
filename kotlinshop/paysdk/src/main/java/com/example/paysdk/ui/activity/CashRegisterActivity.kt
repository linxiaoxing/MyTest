package com.example.paysdk.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.alipay.sdk.app.EnvUtils
import com.alipay.sdk.app.PayTask
import com.example.chen.baselibrary.ext.Onclick
import com.example.chen.baselibrary.ui.activity.BaseMvpActivity
import com.example.chen.provider.router.RouterPath
import com.example.paysdk.R
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.pay.injection.component.DaggerPayComponent
import com.kotlin.pay.injection.module.PayModule
import com.kotlin.pay.presenter.PayPresenter
import com.kotlin.pay.presenter.view.PayView
import com.kotlin.provider.common.ProviderConstant
import kotlinx.android.synthetic.main.activity_cash_register.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

/**
 *收银台界面
 */
@Route(path = RouterPath.PaySDK.PATH_PAY)
class CashRegisterActivity : BaseMvpActivity<PayPresenter>(), PayView {
    //订单号
    var mOrderId:Int = 0
    //订单总价格
    var mTotalPrice:Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cash_register)
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX)
        initView()
        initData()
    }
    /*
       初始化视图
    */
    private fun initView() {
        mAlipayTypeTv.isSelected = true
        mPayBtn.Onclick {
            mPresenter.getPaySign(mOrderId,mTotalPrice)
        }
    }
    /*
      初始化数据
   */
    private fun initData() {
        mOrderId = intent.getIntExtra(ProviderConstant.KEY_ORDER_ID,-1)
        mTotalPrice = intent.getLongExtra(ProviderConstant.KEY_ORDER_PRICE,-1)
        mTotalPriceTv.text = YuanFenConverter.changeF2YWithUnit(mTotalPrice)
    }
    /*
         Dagger注册
      */
    override fun injectComponent() {
        DaggerPayComponent.builder().activityComponent(activityComponent).payModule(PayModule()).build().inject(this)
        mPresenter.mView = this
    }

    /*
        获取支付签名回调
     */
    override fun onGetSignResult(result: String) {
        doAsync {
            val resultMap:Map<String,String> = PayTask(this@CashRegisterActivity).payV2(result,true)
            uiThread {
                if (resultMap["resultStatus"].equals("9000")){
                    mPresenter.payOrder(mOrderId)
                }else{
                    toast("支付失败${resultMap["memo"]}")
                }
            }

        }
    }

    /*
        支付订单回调
     */
    override fun onPayOrderResult(result: Boolean) {
        toast("支付成功")
        finish()
    }
}