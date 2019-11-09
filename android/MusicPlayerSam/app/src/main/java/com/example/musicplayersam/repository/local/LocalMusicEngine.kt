package com.example.musicplayersam.repository.local

import android.os.Environment
import androidx.annotation.VisibleForTesting
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.musicplayersam.repository.db.dao.LocalMusicDao
import com.example.musicplayersam.utils.MusicConverter
import com.example.musicplayersam.utils.component.log
import com.example.musicplayersam.utils.component.support.Resource
import kotlinx.coroutines.isActive
import java.io.File
import kotlin.coroutines.coroutineContext
import com.example.musicplayersam.utils.component.support.Status
import com.example.musicplayersam.utils.getStoragePath
import tech.soit.quiet.model.vo.Music

/**
 * retrieval local music to database
 *
 * @param localMusicDao local music db
 */
class LocalMusicEngine(private val localMusicDao: LocalMusicDao) {

    companion object {


        /** internal and external storage directory */
        private val disks
            get() = listOfNotNull(
                Environment.getExternalStorageDirectory().path,
                getStoragePath(true)
            )


    }

    val states = MutableLiveData<Status>()

    init {
        states.postValue(null)
    }

    val newMusic = MutableLiveData<Resource<Music>>()



    @WorkerThread
    @VisibleForTesting
    private suspend fun traversalDirectory(file: File): Unit = with(file) {
        if (!coroutineContext.isActive) {
            /*to check if canceled*/
            return@with
        }
        if (!exists() || !isDirectory) {
            return@with
        }
        if (path.startsWith(".") || name == "Android") {
            //TODO 文件过滤配置化
            return
        }
        val files = listFiles() ?: return@with
        files.forEach { child ->
            if (child.isDirectory) {
                traversalDirectory(child)
            } else if (child.isFile && child.exists()) {
                onFileEmitted(child)
            }
        }
        Unit
    }

    /** on a file has been traversed */
    private fun onFileEmitted(file: File) {
        log { "scanning file : ${file.path}" }
        if (!isFileAccept(file)) {
            return
        }
        val music = MusicConverter.scanFileToMusic(file)
        if (music != null) {
            localMusicDao.insertMusic(music)
            newMusic.postValue(Resource.success(music))
        }
    }

    private fun isFileAccept(file: File): Boolean {
        return file.path.endsWith(".mp3", true)
    }

}