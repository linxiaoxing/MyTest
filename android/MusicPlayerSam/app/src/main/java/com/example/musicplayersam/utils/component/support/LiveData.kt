package com.example.musicplayersam.utils.component.support

import androidx.lifecycle.MutableLiveData

/**
 * create MutableLiveData with initial value
 */
fun <T> liveDataWith(initial: T): MutableLiveData<T> {
    val liveData = MutableLiveData<T>()
    liveData.postValue(initial)//use post to fit any thread
    return liveData
}