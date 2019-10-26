package com.example.musicplayersam.repository.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import java.lang.reflect.Type

@Entity(tableName = "objects")
data class KeyValueEntity(
    @PrimaryKey
    val key: String,

    @ColumnInfo
    val data: String
) {
    private companion object {

        val GSON = Gson()

    }

    constructor(key: String, value: Any?) : this(key, GSON.toJson(value))

    fun <T> getValue(typeofT: Type): T {
        return GSON.fromJson(data, typeofT)
    }
}

