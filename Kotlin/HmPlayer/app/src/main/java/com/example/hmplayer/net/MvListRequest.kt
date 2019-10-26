package com.example.hmplayer.net

import com.example.hmplayer.model.MvPagerBean
import com.example.hmplayer.util.URLProviderUtils

class MvListRequest(type: Int, code: String, offset: Int, handler: ResponseHandler<MvPagerBean>) :
    MRequest<MvPagerBean>(type, URLProviderUtils.getMVListUrl(code, offset, 20), handler, null)