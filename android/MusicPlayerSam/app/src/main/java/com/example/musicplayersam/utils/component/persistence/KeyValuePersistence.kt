package com.example.musicplayersam.utils.component.persistence

/**
 *
 * save key value pair to persistence
 *
 */
interface KeyValuePersistence {


    /**
     * get value by key, might be null if value is empty or parse failed
     */
    fun <T> get(key: String): T?

    /**
     * save key and value
     *
     * @param any null to remove the value
     *
     */
    fun put(key: String, any: Any?)

}