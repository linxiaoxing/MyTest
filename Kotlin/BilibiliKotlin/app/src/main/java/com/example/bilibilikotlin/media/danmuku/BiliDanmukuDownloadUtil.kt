package com.example.bilibilikotlin.media.danmuku

import io.reactivex.BackpressureStrategy
import master.flame.danmaku.danmaku.parser.IDataSource
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser
import master.flame.danmaku.danmaku.loader.IllegalDataException
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory
import master.flame.danmaku.danmaku.loader.ILoader
import master.flame.danmaku.danmaku.model.android.Danmakus
import master.flame.danmaku.danmaku.model.IDanmakus
import android.text.TextUtils
import io.reactivex.Flowable
import java.io.ByteArrayInputStream
import java.io.IOException
import java.util.zip.DataFormatException

import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;


/**
 * 描述:视频弹幕下载
 */
object BiliDanmukuDownloadUtil {
    fun downloadXML(uri: String): Flowable<BaseDanmakuParser> {
        return Flowable.create({ emitter ->
            if (TextUtils.isEmpty(uri)) {
                emitter.onNext(object : BaseDanmakuParser() {
                    override fun parse(): IDanmakus {
                        return Danmakus()
                    }
                })
            }
            var loader: ILoader? = null
            try {
                val rsp = Jsoup.connect(uri).timeout(20000).execute() as HttpConnection.Response
                val stream =
                    ByteArrayInputStream(BiliDanmukuCompressionTools.decompressXML(rsp.bodyAsBytes()))

                loader = DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI)
                loader!!.load(stream)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: DataFormatException) {
                e.printStackTrace()
            } catch (e: IllegalDataException) {
                e.printStackTrace()
            }

            val parser = BiliDanmukuParser()
            assert(loader != null)
            val dataSource = loader!!.dataSource
            parser.load(dataSource)
            emitter.onNext(parser)
        }, BackpressureStrategy.BUFFER)
    }
}