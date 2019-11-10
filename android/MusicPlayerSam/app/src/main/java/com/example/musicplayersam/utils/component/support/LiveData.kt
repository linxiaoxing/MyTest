package com.example.musicplayersam.utils.component.support

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * create MutableLiveData with initial value
 */
fun <T> liveDataWith(initial: T): MutableLiveData<T> {
    val liveData = MutableLiveData<T>()
    liveData.postValue(initial)//use post to fit any thread
    return liveData
}


/**
 * observe LiveData but filter null change
 *
 * @see LiveData.observe
 */
fun <T> LiveData<T>.observeNonNull(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
    observe(lifecycleOwner, Observer {
        if (it != null) {
            observer(it)
        }
    })
}