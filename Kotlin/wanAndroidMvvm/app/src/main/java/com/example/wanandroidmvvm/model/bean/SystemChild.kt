package com.example.wanandroidmvvm.model.bean

import java.io.Serializable

data class SystemChild(val child: List<SystemChild>,
                       val courseId: Int,
                       val id: Int,
                       val name: String,
                       val order: Int,
                       val parentChapterId: Int,
                       val visible: Int): Serializable