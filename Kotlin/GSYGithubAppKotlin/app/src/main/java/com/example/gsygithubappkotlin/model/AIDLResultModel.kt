package com.example.gsygithubappkotlin.model

import android.os.Parcel
import android.os.Parcelable

class AIDLResultModel() : Parcelable {

    var name: String? = null

    var time: Long = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        time = parcel.readLong()
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeLong(time)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<AIDLResultModel> {
        override fun createFromParcel(source: Parcel): AIDLResultModel {
            val result = AIDLResultModel()
            result.name = source.readString()
            result.time = source.readLong()
            return result
        }

        override fun newArray(size: Int): Array<AIDLResultModel?> {
            return arrayOfNulls(size)
        }
    }


    override fun toString(): String = "name : $name time : $time "

}