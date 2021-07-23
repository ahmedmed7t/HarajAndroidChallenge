package com.advradiuspro.advradiuspro.module


import com.example.harajtask.UI.List.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }
}