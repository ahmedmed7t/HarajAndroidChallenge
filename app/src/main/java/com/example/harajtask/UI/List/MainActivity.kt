package com.example.harajtask.UI.List

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.advradiuspro.advradiuspro.ui.Profiles.Adapter.PostRecyclerAdapter
import com.example.harajtask.R
import com.example.harajtask.UI.Details.DetailsActivity
import com.example.harajtask.Utils.CallBackCaller
import com.google.gson.Gson
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private val postViewModel : PostsViewModel by inject()


    private lateinit var postRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postRecyclerView  = findViewById(R.id.Post_Recycler_View)

        postRecyclerView.layoutManager = LinearLayoutManager(this)
        postRecyclerView.setHasFixedSize(true)

        listenToViewModelValues()
    }

    private fun listenToViewModelValues(){
        postViewModel.posts.observe(this, Observer {
            val adapter : PostRecyclerAdapter = PostRecyclerAdapter(it, object : CallBackCaller {
                override fun onClick(value: Int) {
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    intent.putExtra("PostModel", Gson().toJson(postViewModel.posts.value?.get(value)))
                    startActivity(intent)
                }
            })
            postRecyclerView.adapter = adapter
        })
    }

}