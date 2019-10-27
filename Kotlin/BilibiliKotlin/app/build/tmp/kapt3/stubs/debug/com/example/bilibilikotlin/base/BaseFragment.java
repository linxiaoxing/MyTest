package com.example.bilibilikotlin.base;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010*\u001a\u00020+H\u0014J\u0012\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020+H\u0014J\b\u00100\u001a\u0004\u0018\u00010\nJ\b\u00101\u001a\u000202H&J\u001f\u00103\u001a\u00020+2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020%05\"\u00020%\u00a2\u0006\u0002\u00106J\b\u00107\u001a\u00020+H\u0014J\b\u00108\u001a\u00020+H\u0014J\b\u00109\u001a\u00020+H\u0014J\b\u0010:\u001a\u00020+H\u0014J\b\u0010;\u001a\u00020+H\u0015J\b\u0010<\u001a\u00020+H\u0014J\b\u0010=\u001a\u00020+H\u0016J\b\u0010>\u001a\u00020+H\u0016J\b\u0010?\u001a\u00020+H\u0014J\b\u0010@\u001a\u00020+H\u0014J\b\u0010A\u001a\u00020+H\u0014J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\nH\u0016J&\u0010D\u001a\u0004\u0018\u00010%2\u0006\u0010E\u001a\u00020\u00162\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010.H\u0016J\b\u0010I\u001a\u00020+H\u0016J\b\u0010J\u001a\u00020+H\u0014J\u001a\u0010K\u001a\u00020+2\u0006\u0010L\u001a\u00020%2\b\u0010H\u001a\u0004\u0018\u00010.H\u0016J\b\u0010M\u001a\u00020+H\u0014J\u0010\u0010N\u001a\u00020+2\u0006\u0010O\u001a\u00020\u001cH\u0016J\u001f\u0010P\u001a\u00020+2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020%05\"\u00020%\u00a2\u0006\u0002\u00106R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)\u00a8\u0006Q"}, d2 = {"Lcom/example/bilibilikotlin/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mActivity", "Landroid/app/Activity;", "getMActivity", "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mError", "Landroid/widget/LinearLayout;", "getMError", "()Landroid/widget/LinearLayout;", "setMError", "(Landroid/widget/LinearLayout;)V", "mInflater", "Landroid/view/LayoutInflater;", "getMInflater", "()Landroid/view/LayoutInflater;", "setMInflater", "(Landroid/view/LayoutInflater;)V", "mIsPrepared", "", "getMIsPrepared", "()Z", "setMIsPrepared", "(Z)V", "mIsVisible", "getMIsVisible", "setMIsVisible", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "clearData", "", "finishCreateView", "state", "Landroid/os/Bundle;", "finishTask", "getApplicationContext", "getLayoutId", "", "gone", "views", "", "([Landroid/view/View;)V", "initDatas", "initInject", "initPresenter", "initRecyclerView", "initRefreshLayout", "initSetListener", "initVariables", "initWidget", "lazyLoad", "lazyLoadData", "loadData", "onAttach", "context", "onCreateView", "inflater", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "onDetach", "onInvisible", "onViewCreated", "view", "onVisible", "setUserVisibleHint", "isVisibleToUser", "visible", "app_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private android.view.View mRootView;
    @org.jetbrains.annotations.Nullable()
    private android.app.Activity mActivity;
    @org.jetbrains.annotations.Nullable()
    private android.view.LayoutInflater mInflater;
    @org.jetbrains.annotations.Nullable()
    private android.content.Context mContext;
    private boolean mIsPrepared;
    private boolean mIsVisible;
    @org.jetbrains.annotations.Nullable()
    private android.widget.LinearLayout mError;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    protected final android.view.View getMRootView() {
        return null;
    }
    
    protected final void setMRootView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.app.Activity getMActivity() {
        return null;
    }
    
    protected final void setMActivity(@org.jetbrains.annotations.Nullable()
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.view.LayoutInflater getMInflater() {
        return null;
    }
    
    protected final void setMInflater(@org.jetbrains.annotations.Nullable()
    android.view.LayoutInflater p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.content.Context getMContext() {
        return null;
    }
    
    protected final void setMContext(@org.jetbrains.annotations.Nullable()
    android.content.Context p0) {
    }
    
    protected final boolean getMIsPrepared() {
        return false;
    }
    
    protected final void setMIsPrepared(boolean p0) {
    }
    
    protected final boolean getMIsVisible() {
        return false;
    }
    
    protected final void setMIsVisible(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.widget.LinearLayout getMError() {
        return null;
    }
    
    protected final void setMError(@org.jetbrains.annotations.Nullable()
    android.widget.LinearLayout p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    protected void initSetListener() {
    }
    
    protected void lazyLoadData() {
    }
    
    protected void initDatas() {
    }
    
    public void finishCreateView(@org.jetbrains.annotations.Nullable()
    android.os.Bundle state) {
    }
    
    /**
     * 分离
     */
    @java.lang.Override()
    public void onDetach() {
    }
    
    /**
     * 初始化RV
     */
    protected void initRecyclerView() {
    }
    
    /**
     * 初始化刷新
     */
    @android.annotation.SuppressLint(value = {"CheckResult"})
    protected void initRefreshLayout() {
    }
    
    /**
     * 清除数据
     */
    protected void clearData() {
    }
    
    /**
     * 初始化Presenter
     */
    protected void initPresenter() {
    }
    
    /**
     * 初始化变量
     */
    public void initVariables() {
    }
    
    /**
     * 懒加载
     */
    protected void lazyLoad() {
    }
    
    protected void onInvisible() {
    }
    
    /**
     * 加载数据
     */
    protected void loadData() {
    }
    
    /**
     * 注入dagger2依赖
     */
    protected void initInject() {
    }
    
    protected void finishTask() {
    }
    
    /**
     * 布局
     * @return int
     */
    public abstract int getLayoutId();
    
    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public void initWidget() {
    }
    
    protected void onVisible() {
    }
    
    /**
     * Fragment数据的懒加载
     * @param isVisibleToUser
     */
    @java.lang.Override()
    public void setUserVisibleHint(boolean isVisibleToUser) {
    }
    
    /**
     * 获取ApplicationContext 信息
     * @return Context
     */
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context getApplicationContext() {
        return null;
    }
    
    /**
     * 隐藏View
     * @param views 视图
     */
    public final void gone(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    /**
     * 显示View
     * @param views 视图
     */
    public final void visible(@org.jetbrains.annotations.NotNull()
    android.view.View... views) {
    }
    
    public BaseFragment() {
        super();
    }
}