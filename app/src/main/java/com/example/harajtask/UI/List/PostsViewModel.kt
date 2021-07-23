package com.example.harajtask.UI.List

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.harajtask.data.Model.Post
import com.example.harajtask.data.Repository.PostsRepository

class PostsViewModel(val postsRepository: PostsRepository): ViewModel() {
    private val _posts = MutableLiveData<ArrayList<Post>>()
    val posts: LiveData<ArrayList<Post>>
        get() = _posts

    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        postsRepository.getUserDetails()?.let {
            _posts.value = ArrayList(it)
        }
    }
}