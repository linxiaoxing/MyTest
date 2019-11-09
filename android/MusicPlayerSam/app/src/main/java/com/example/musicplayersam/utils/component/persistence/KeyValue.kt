package com.example.musicplayersam.utils.component.persistence

import android.util.Base64
import com.example.musicplayersam.repository.db.QuietDatabase
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.lang.reflect.Type

/**
 *
 * @see KeyValuePersistence
 *
 * @author : summer
 * @date : 18-8-20
 */
object KeyValue : KeyValuePersistence {

    private val impl: KeyValuePersistence get() = QuietDatabase.instance.keyValueDao()

    override fun <T> get(key: String): T? {
        return impl.get(key)
    }

    override fun put(key: String, any: Any?) {
        impl.put(key, any)
    }

    fun objectToString(obj: Serializable?): String? {
        obj ?: return null
        return try {
            val bos = ByteArrayOutputStream()
            val out = ObjectOutputStream(bos)
            out.writeObject(obj)
            out.flush()

            val string = Base64.encodeToString(bos.toByteArray(), Base64.DEFAULT)
            out.close()
            bos.close()

            string
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun <T> objectFromString(str: String?): T? {
        str ?: return null
        @Suppress("UNCHECKED_CAST")
        return try {
            val bis = ByteArrayInputStream(Base64.decode(str, Base64.DEFAULT))
            val i = ObjectInputStream(bis)
            val any = i.readObject()
            any as T
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}

/**
 * @see KeyValuePersistence.get
 */
inline fun <reified T> KeyValuePersistence.get(key: String): T? {
    return get(key)
}