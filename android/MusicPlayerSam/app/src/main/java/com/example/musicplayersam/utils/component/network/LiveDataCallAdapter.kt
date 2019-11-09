package com.example.musicplayersam.utils.component.network

import androidx.lifecycle.LiveData
import com.example.musicplayersam.utils.component.support.Resource
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

class LiveDataCallAdapter<R>(
    private val responseType: Type
) : CallAdapter<R, LiveData<Resource<R>>> {
    override fun adapt(call: Call<R>): LiveData<Resource<R>> {

        return object : LiveData<Resource<R>>() {
            private val started = AtomicBoolean(false)

            override fun onActive() {
                super.onActive()
                if (started.compareAndSet(false, true)) {
                    call.enqueue(object : Callback<R> {
                        override fun onFailure(call: Call<R>, t: Throwable) {
                            postValue(Resource.error(t.message ?: ""))
                        }

                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            val body = response.body()
                            postValue(Resource.success(body))
                        }
                    })
                }
            }

        }
    }

    override fun responseType(): Type {
        return responseType
    }
}