package com.example.hmplayer.net

import com.example.hmplayer.model.HomeItemBean
import com.example.hmplayer.util.URLProviderUtils

class HomeRequest(offset: Int, handler: ResponseHandler<List<HomeItemBean>>) :
    MRequest<List<HomeItemBean>>(URLProviderUtils.getHomeUrl(offset, 20), handler) {

}