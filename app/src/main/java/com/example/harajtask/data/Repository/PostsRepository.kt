package com.example.harajtask.data.Repository

import com.advradiuspro.advradiuspro.data.api.DashboardApi.PostsDataSourceHelper

class PostsRepository(private val postsDataSourceHelper: PostsDataSourceHelper) {
    fun getUserDetails() = postsDataSourceHelper.getUserDetails()
}