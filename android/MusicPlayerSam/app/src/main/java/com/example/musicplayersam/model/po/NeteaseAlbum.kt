package tech.soit.quiet.model.po

import com.example.musicplayersam.repository.netease.source.NeteaseGlideUrl
import com.example.musicplayersam.utils.string
import com.google.gson.JsonObject
import kotlinx.android.parcel.Parcelize
import tech.soit.quiet.model.vo.Album

@Parcelize
class NeteaseAlbum(
        private val id: Long,
        private val name: String,
        private val imageUrl: String
) : Album() {

    companion object {

        /**
         * @param al 网易云音乐API json
         */
        fun fromJson(al: JsonObject): NeteaseAlbum {
            return NeteaseAlbum(al["id"].asLong, al["name"].string, al["picUrl"].string)
        }

    }

    override fun getCoverImageUrl(): Any {
        return NeteaseGlideUrl(imageUrl)
    }

    override fun getName(): String {
        return name
    }

    override fun getId(): Long {
        return id
    }

}