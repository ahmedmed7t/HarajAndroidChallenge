package com.example.harajtask

import android.app.Application
import com.advradiuspro.advradiuspro.module.appModule
import com.advradiuspro.advradiuspro.module.repoModule
import com.advradiuspro.advradiuspro.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import java.util.*

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(viewModelModule, appModule, repoModule))
        }
    }


}