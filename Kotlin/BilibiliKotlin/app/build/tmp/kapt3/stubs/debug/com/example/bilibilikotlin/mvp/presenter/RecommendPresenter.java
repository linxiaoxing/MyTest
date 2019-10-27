package com.example.bilibilikotlin.mvp.presenter;

import java.lang.System;

/**
 * * 描述:首页直播Presenter
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/example/bilibilikotlin/mvp/presenter/RecommendPresenter;", "Lcom/example/bilibilikotlin/base/RxPresenter;", "Lcom/example/bilibilikotlin/mvp/contract/home/RecommendContract$View;", "Lcom/example/bilibilikotlin/mvp/contract/home/RecommendContract$Presenter;", "retrofitHelper", "Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;", "(Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;)V", "getRecommendData", "", "app_debug"})
public final class RecommendPresenter extends com.example.bilibilikotlin.base.RxPresenter<com.example.bilibilikotlin.mvp.contract.home.RecommendContract.View> implements com.example.bilibilikotlin.mvp.contract.home.RecommendContract.Presenter<com.example.bilibilikotlin.mvp.contract.home.RecommendContract.View> {
    private final com.example.bilibilikotlin.network.helper.RetrofitHelper retrofitHelper = null;
    
    @java.lang.Override()
    public void getRecommendData() {
    }
    
    @javax.inject.Inject()
    public RecommendPresenter(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.helper.RetrofitHelper retrofitHelper) {
        super();
    }
}