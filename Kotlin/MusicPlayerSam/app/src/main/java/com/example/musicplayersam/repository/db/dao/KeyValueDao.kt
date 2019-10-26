package com.example.musicplayersam.repository.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicplayersam.repository.db.entity.KeyValueEntity
import com.example.musicplayersam.utils.component.persistence.KeyValuePersistence
import java.lang.reflect.Type
import kotlin.math.log

@Dao
abstract class KeyValueDao : KeyValuePersistence {

    @Query("select * from objects where `key` == :key")
    protected abstract fun findEntity(key: String): KeyValueEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun insert(objectWrapperEntity: KeyValueEntity)

    override fun <T> get(key: String, typeofT: Type?): T? {
        val entity = findEntity(key) ?: return null
        try {
            return entity.getValue(typeofT!!)
        } catch (e: Exception) {
            // log(LoggerLevel.ERROR) { "parse key($key) failed : ${entity.data} " }
            put(key, null)
        }
        return null
    }

    override fun put(key: String, any: Any?) {
        try {
            val wrapper = KeyValueEntity(key, any)
            insert(wrapper)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}