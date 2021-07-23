package com.advradiuspro.advradiuspro.data.api.DashboardApi

import android.content.Context
import com.example.harajtask.data.Model.Post

interface PostsDataSourceHelper {
    fun getUserDetails() : List<Post>?
}