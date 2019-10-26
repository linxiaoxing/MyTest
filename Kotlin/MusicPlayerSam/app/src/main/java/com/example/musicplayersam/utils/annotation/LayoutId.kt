package com.example.musicplayersam.utils.annotation

import androidx.annotation.LayoutRes
import java.lang.annotation.Inherited

@Target(AnnotationTarget.CLASS)
@Inherited
annotation class LayoutId(
    @LayoutRes val value: Int,
    val translucent: Boolean = true
)