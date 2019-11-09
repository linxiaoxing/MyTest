package com.example.musicplayersam.ui.item

import com.example.musicplayersam.R
import kotlinx.android.synthetic.main.item_setting_folder_filter.view.*
import java.io.File

import tech.soit.typed.adapter.TypedBinder
import tech.soit.typed.adapter.ViewHolder
import tech.soit.typed.adapter.annotation.TypeLayoutResource

/**
 * @param path 目录路径
 * @param isChecked 是否被标记为过滤
 */
data class SettingScannerFolderFilter(
    val path: String,
    val isChecked: Boolean
) {

    val name: String get() = path.substringAfterLast(File.separator)

    val parent: String get() = path.substringBeforeLast(File.separator)

}


/**
 * for [tech.soit.quiet.ui.fragment.local.LocalMusicScannerSettingFragment]
 */
@TypeLayoutResource(R.layout.item_setting_folder_filter)
class SettingScannerFolderFilterBinder : TypedBinder<SettingScannerFolderFilter>() {

    override fun onBindViewHolder(holder: ViewHolder, item: SettingScannerFolderFilter) = with(holder.itemView) {
        checkbox.isChecked = item.isChecked
        textTitle.text = item.name
        textSubTitle.text = item.parent
        setOnClickListener {
            //TODO
        }
        Unit
    }

}