package com.example.hmplayer.net

import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.util.URLProviderUtils

class HomeRequest(type: Int, offset: Int, handler: ResponseHandler<List<HomeItemBean>>) :
    MRequest<List<HomeItemBean>>(type, URLProviderUtils.getHomeUrl(offset, 20), handler) {

}