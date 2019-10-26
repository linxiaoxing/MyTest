package com.example.hmplayer.util

import android.os.Environment
import java.io.File

/**
 * @Description 歌词加载类
 */
object LyricLoader {
    private val dir = File(Environment.getExternalStorageDirectory(), "Download/Lyric")
    fun LoadLyricFile(displayName: String): File {
        return File(dir, "$displayName.lrc")
    }
}