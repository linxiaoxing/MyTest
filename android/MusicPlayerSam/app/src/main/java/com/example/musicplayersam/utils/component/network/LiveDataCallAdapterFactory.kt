package com.example.musicplayersam.utils.component.network

import androidx.lifecycle.LiveData
import com.google.gson.internal.`$Gson$Types`.getRawType
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

class LiveDataCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != LiveData::class.java){
            return null
        }
        TODO()
    }

}