package com.example.wankotlin.mvp.model.bean

import com.chad.library.adapter.base.entity.SectionEntity

class TodoDataBean : SectionEntity<TodoBean> {

    constructor(isHeader: Boolean, headerName: String) : super(isHeader, headerName)

    constructor(todoBean: TodoBean) : super(todoBean)

}