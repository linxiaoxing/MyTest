package tech.soit.quiet.model.po

import com.example.musicplayersam.repository.netease.source.NeteaseGlideUrl
import com.google.gson.JsonObject
import tech.soit.quiet.model.vo.PlayList

class NeteasePlayList(private val jsonObject: JsonObject) : PlayList() {

    override fun getDescription(): String {
        return jsonObject["description"].asString
    }

    override fun getCoverImageUrl(): NeteaseGlideUrl {
        return NeteaseGlideUrl(jsonObject["coverImgUrl"].asString)
    }

    override fun getTrackCount(): Int {
        return jsonObject["trackCount"].asInt
    }

    override fun getName(): String {
        return jsonObject["name"].asString
    }

    override fun getId(): Long {
        return jsonObject["id"].asLong
    }

    override fun getUserId(): Long {
        return jsonObject["userId"].asLong
    }


}