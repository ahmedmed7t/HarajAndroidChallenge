package com.advradiuspro.advradiuspro.module

import com.advradiuspro.advradiuspro.data.api.DashboardApi.PostsDataSourceHelper
import com.advradiuspro.advradiuspro.data.api.DashboardApi.PostsDataSourceHelperImp
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single<PostsDataSourceHelper> {
        return@single PostsDataSourceHelperImp(androidContext())
    }

}