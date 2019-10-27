package com.example.bilibilikotlin.module.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007H\u0007J\u0006\u0010\u001f\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/bilibilikotlin/module/app/MainActivity;", "Lcom/example/bilibilikotlin/base/BaseActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "()V", "exitTime", "", "mCurrentPos", "", "mFragments", "", "Landroidx/fragment/app/Fragment;", "disableNavigationViewScrollbars", "", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "exitApp", "getLayoutId", "initFragment", "initStatusBar", "initVariables", "initWidget", "onKeyDown", "", "keyCode", "event", "Landroid/view/KeyEvent;", "onNavigationItemSelected", "p0", "Landroid/view/MenuItem;", "switchFragmentIndex", "index", "toggleDrawer", "app_debug"})
public final class MainActivity extends com.example.bilibilikotlin.base.BaseActivity implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener {
    private long exitTime;
    private int mCurrentPos;
    private java.util.List<androidx.fragment.app.Fragment> mFragments;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public int getLayoutId() {
        return 0;
    }
    
    private final void initFragment() {
    }
    
    @java.lang.Override()
    public void initWidget() {
    }
    
    @android.annotation.SuppressLint(value = {"CommitTransaction"})
    public final void switchFragmentIndex(int index) {
    }
    
    @java.lang.Override()
    public void initStatusBar() {
    }
    
    @java.lang.Override()
    public void initVariables() {
    }
    
    /**
     * DrawerLayout侧滑菜单开关
     */
    public final void toggleDrawer() {
    }
    
    /**
     * 去掉滚动条
     * @param navigationView navigationView
     */
    private final void disableNavigationViewScrollbars(com.google.android.material.navigation.NavigationView navigationView) {
    }
    
    /**
     * 侧滑面板监听事件
     * @param item
     * *
     * @return
     */
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem p0) {
        return false;
    }
    
    /**
     * 监听back键处理
     */
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    /**
     * 双击退出App
     */
    private final void exitApp() {
    }
    
    public MainActivity() {
        super();
    }
}