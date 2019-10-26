package com.example.hmplayer.net

import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.YueDanBean
import com.example.hmplayer.util.URLProviderUtils

/**
 * @Description 悦单网络请求类
 */
class YueDanRequest(type: Int, offset: Int, handler: ResponseHandler<YueDanBean>, fragment: BaseFragment) :
        MRequest<YueDanBean>(type, URLProviderUtils.getYueDanUrl(offset, 20), handler, fragment)
