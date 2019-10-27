package com.example.gsygithubappkotlin.ui;

import java.lang.System;

/**
 * 自带Shape按键
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0014\n\u0002\b\u001b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J\u0010\u00104\u001a\u0002012\b\b\u0001\u00105\u001a\u00020\u0007J\u0010\u00106\u001a\u0002012\b\b\u0001\u00107\u001a\u00020\u0007J\u000e\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u0007J\u0010\u0010:\u001a\u0002012\b\b\u0001\u0010;\u001a\u00020\u0007J\u0010\u0010<\u001a\u0002012\b\b\u0001\u0010=\u001a\u00020\u0007J\u0010\u0010>\u001a\u0002012\b\b\u0001\u0010?\u001a\u00020\u0007J\u000e\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\u0007J\u0010\u0010B\u001a\u0002012\b\b\u0001\u0010C\u001a\u00020\u0007J\u0010\u0010D\u001a\u0002012\b\b\u0001\u0010E\u001a\u00020\u0016J\u000e\u0010D\u001a\u0002012\u0006\u0010F\u001a\u00020GJ\u000e\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020\u0018J$\u0010J\u001a\u0002012\b\b\u0001\u0010K\u001a\u00020\u00072\b\b\u0001\u0010L\u001a\u00020\u00072\b\b\u0001\u0010M\u001a\u00020\u0007J$\u0010N\u001a\u0002012\b\b\u0001\u0010K\u001a\u00020\u00072\b\b\u0001\u0010L\u001a\u00020\u00072\b\b\u0001\u0010M\u001a\u00020\u0007J\u001e\u0010O\u001a\u0002012\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007J$\u0010P\u001a\u0002012\b\b\u0001\u0010K\u001a\u00020\u00072\b\b\u0001\u0010L\u001a\u00020\u00072\b\b\u0001\u0010M\u001a\u00020\u0007J\b\u0010Q\u001a\u000201H\u0002J \u0010Q\u001a\u0002012\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0002J\u0016\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020\u00162\u0006\u0010W\u001a\u00020\u0016J\b\u0010X\u001a\u000201H\u0002J\u0010\u0010Y\u001a\u0002012\b\b\u0001\u0010Z\u001a\u00020\u0007J\u0010\u0010[\u001a\u0002012\b\b\u0001\u0010\\\u001a\u00020\u0007J\u000e\u0010]\u001a\u0002012\u0006\u0010^\u001a\u00020\u0007J\u0010\u0010_\u001a\u0002012\b\b\u0001\u0010`\u001a\u00020\u0007J\u0012\u0010a\u001a\u0002012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010\'\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010-X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010/\u00a8\u0006b"}, d2 = {"Lcom/example/gsygithubappkotlin/ui/StateButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDuration", "mNormalBackground", "Landroid/graphics/drawable/GradientDrawable;", "mNormalBackgroundColor", "mNormalStrokeColor", "mNormalStrokeWidth", "mNormalTextColor", "mPressedBackground", "mPressedBackgroundColor", "mPressedStrokeColor", "mPressedStrokeWidth", "mPressedTextColor", "mRadius", "", "mRound", "", "mStateBackground", "Landroid/graphics/drawable/StateListDrawable;", "getMStateBackground", "()Landroid/graphics/drawable/StateListDrawable;", "setMStateBackground", "(Landroid/graphics/drawable/StateListDrawable;)V", "mStrokeDashGap", "mStrokeDashWidth", "mTextColorStateList", "Landroid/content/res/ColorStateList;", "getMTextColorStateList", "()Landroid/content/res/ColorStateList;", "setMTextColorStateList", "(Landroid/content/res/ColorStateList;)V", "mUnableBackground", "mUnableBackgroundColor", "mUnableStrokeColor", "mUnableStrokeWidth", "mUnableTextColor", "states", "", "", "[[I", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setNormalBackgroundColor", "normalBackgroundColor", "setNormalStrokeColor", "normalStrokeColor", "setNormalStrokeWidth", "normalStrokeWidth", "setNormalTextColor", "normalTextColor", "setPressedBackgroundColor", "pressedBackgroundColor", "setPressedStrokeColor", "pressedStrokeColor", "setPressedStrokeWidth", "pressedStrokeWidth", "setPressedTextColor", "pressedTextColor", "setRadius", "radius", "radii", "", "setRound", "round", "setStateBackgroundColor", "normal", "pressed", "unable", "setStateStrokeColor", "setStateStrokeWidth", "setStateTextColor", "setStroke", "mBackground", "mStrokeColor", "mStrokeWidth", "setStrokeDash", "strokeDashWidth", "strokeDashGap", "setTextColor", "setUnableBackgroundColor", "unableBackgroundColor", "setUnableStrokeColor", "unableStrokeColor", "setUnableStrokeWidth", "unableStrokeWidth", "setUnableTextColor", "unableTextColor", "setup", "app_debug"})
public final class StateButton extends androidx.appcompat.widget.AppCompatButton {
    private int mNormalTextColor;
    private int mPressedTextColor;
    private int mUnableTextColor;
    @org.jetbrains.annotations.NotNull()
    public android.content.res.ColorStateList mTextColorStateList;
    private int mDuration;
    private float mRadius;
    private boolean mRound;
    private float mStrokeDashWidth;
    private float mStrokeDashGap;
    private int mNormalStrokeWidth;
    private int mPressedStrokeWidth;
    private int mUnableStrokeWidth;
    private int mNormalStrokeColor;
    private int mPressedStrokeColor;
    private int mUnableStrokeColor;
    private int mNormalBackgroundColor;
    private int mPressedBackgroundColor;
    private int mUnableBackgroundColor;
    private android.graphics.drawable.GradientDrawable mNormalBackground;
    private android.graphics.drawable.GradientDrawable mPressedBackground;
    private android.graphics.drawable.GradientDrawable mUnableBackground;
    private int[][] states;
    @org.jetbrains.annotations.NotNull()
    public android.graphics.drawable.StateListDrawable mStateBackground;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.res.ColorStateList getMTextColorStateList() {
        return null;
    }
    
    public final void setMTextColorStateList(@org.jetbrains.annotations.NotNull()
    android.content.res.ColorStateList p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.graphics.drawable.StateListDrawable getMStateBackground() {
        return null;
    }
    
    public final void setMStateBackground(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.StateListDrawable p0) {
    }
    
    private final void setup(android.util.AttributeSet attrs) {
    }
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    /**
     * **************** stroke color
     */
    public final void setNormalStrokeColor(@androidx.annotation.ColorInt()
    int normalStrokeColor) {
    }
    
    public final void setPressedStrokeColor(@androidx.annotation.ColorInt()
    int pressedStrokeColor) {
    }
    
    public final void setUnableStrokeColor(@androidx.annotation.ColorInt()
    int unableStrokeColor) {
    }
    
    public final void setStateStrokeColor(@androidx.annotation.ColorInt()
    int normal, @androidx.annotation.ColorInt()
    int pressed, @androidx.annotation.ColorInt()
    int unable) {
    }
    
    /**
     * **************** stroke width
     */
    public final void setNormalStrokeWidth(int normalStrokeWidth) {
    }
    
    public final void setPressedStrokeWidth(int pressedStrokeWidth) {
    }
    
    public final void setUnableStrokeWidth(int unableStrokeWidth) {
    }
    
    public final void setStateStrokeWidth(int normal, int pressed, int unable) {
    }
    
    public final void setStrokeDash(float strokeDashWidth, float strokeDashGap) {
    }
    
    private final void setStroke() {
    }
    
    private final void setStroke(android.graphics.drawable.GradientDrawable mBackground, int mStrokeColor, int mStrokeWidth) {
    }
    
    /**
     * ******************   radius
     */
    public final void setRadius(@androidx.annotation.FloatRange(from = 0.0)
    float radius) {
    }
    
    public final void setRound(boolean round) {
    }
    
    public final void setRadius(@org.jetbrains.annotations.NotNull()
    float[] radii) {
    }
    
    /**
     * ******************  background color
     */
    public final void setStateBackgroundColor(@androidx.annotation.ColorInt()
    int normal, @androidx.annotation.ColorInt()
    int pressed, @androidx.annotation.ColorInt()
    int unable) {
    }
    
    public final void setNormalBackgroundColor(@androidx.annotation.ColorInt()
    int normalBackgroundColor) {
    }
    
    public final void setPressedBackgroundColor(@androidx.annotation.ColorInt()
    int pressedBackgroundColor) {
    }
    
    public final void setUnableBackgroundColor(@androidx.annotation.ColorInt()
    int unableBackgroundColor) {
    }
    
    /**
     * *************  text color
     */
    private final void setTextColor() {
    }
    
    public final void setStateTextColor(@androidx.annotation.ColorInt()
    int normal, @androidx.annotation.ColorInt()
    int pressed, @androidx.annotation.ColorInt()
    int unable) {
    }
    
    public final void setNormalTextColor(@androidx.annotation.ColorInt()
    int normalTextColor) {
    }
    
    public final void setPressedTextColor(@androidx.annotation.ColorInt()
    int pressedTextColor) {
    }
    
    public final void setUnableTextColor(@androidx.annotation.ColorInt()
    int unableTextColor) {
    }
    
    public StateButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public StateButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public StateButton(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}