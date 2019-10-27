package com.example.bilibilikotlin.mvp.presenter.live;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u000b\u001a\u00020\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/bilibilikotlin/mvp/presenter/live/LivePresenter;", "Lcom/example/bilibilikotlin/base/RxPresenter;", "Lcom/example/bilibilikotlin/mvp/contract/home/LiveContract$View;", "Lcom/example/bilibilikotlin/mvp/contract/home/LiveContract$Presenter;", "retrofitHelper", "Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;", "(Lcom/example/bilibilikotlin/network/helper/RetrofitHelper;)V", "livePartition", "Lcom/example/bilibilikotlin/bean/live/LivePartition;", "getLivePartition", "()Lcom/example/bilibilikotlin/bean/live/LivePartition;", "setLivePartition", "(Lcom/example/bilibilikotlin/bean/live/LivePartition;)V", "getLiveData", "", "readJSONFromAsset", "", "app_debug"})
public final class LivePresenter extends com.example.bilibilikotlin.base.RxPresenter<com.example.bilibilikotlin.mvp.contract.home.LiveContract.View> implements com.example.bilibilikotlin.mvp.contract.home.LiveContract.Presenter<com.example.bilibilikotlin.mvp.contract.home.LiveContract.View> {
    @org.jetbrains.annotations.Nullable()
    private com.example.bilibilikotlin.bean.live.LivePartition livePartition;
    private final com.example.bilibilikotlin.network.helper.RetrofitHelper retrofitHelper = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.bilibilikotlin.bean.live.LivePartition getLivePartition() {
        return null;
    }
    
    public final void setLivePartition(@org.jetbrains.annotations.Nullable()
    com.example.bilibilikotlin.bean.live.LivePartition p0) {
    }
    
    @java.lang.Override()
    public void getLiveData() {
    }
    
    public final void setLivePartition() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String readJSONFromAsset() {
        return null;
    }
    
    @javax.inject.Inject()
    public LivePresenter(@org.jetbrains.annotations.NotNull()
    com.example.bilibilikotlin.network.helper.RetrofitHelper retrofitHelper) {
        super();
    }
}