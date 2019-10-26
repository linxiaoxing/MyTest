package com.example.hmplayer.net

import com.example.hmplayer.base.BaseFragment
import com.example.hmplayer.model.MvAreaBean
import com.example.hmplayer.util.URLProviderUtils

/**
 * @Description MvFragment顶部tab数据请求
 */
class MvAreaRequest(handler: ResponseHandler<List<MvAreaBean>>, fragment: BaseFragment) :
    MRequest<List<MvAreaBean>>(0, URLProviderUtils.getMVareaUrl(), handler, fragment)