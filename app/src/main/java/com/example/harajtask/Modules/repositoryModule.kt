package com.advradiuspro.advradiuspro.module

import com.example.harajtask.data.Repository.PostsRepository
import org.koin.dsl.module

val repoModule = module {
    single {
        PostsRepository(get())
    }
}