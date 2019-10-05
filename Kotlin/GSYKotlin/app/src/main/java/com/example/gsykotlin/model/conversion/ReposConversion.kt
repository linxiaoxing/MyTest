package com.example.gsykotlin.model.conversion

import com.example.gsykotlin.model.bean.TrendingRepoModel
import com.example.gsykotlin.model.ui.ReposUIModel

/**
 * 仓库相关实体转换
 */
object ReposConversion {

    fun trendToReposUIModel(trendModel: TrendingRepoModel): ReposUIModel {
        val reposUIModel = ReposUIModel()
        reposUIModel.hideWatchIcon = true
        reposUIModel.ownerName = trendModel.name
        reposUIModel.ownerPic = trendModel.contributors[0]
        reposUIModel.repositoryDes = trendModel.description
        reposUIModel.repositoryName = trendModel.reposName
        reposUIModel.repositoryFork = trendModel.forkCount
        reposUIModel.repositoryStar = trendModel.starCount
        reposUIModel.repositoryWatch = trendModel.meta
        reposUIModel.repositoryType = trendModel.language
        return reposUIModel
    }

}