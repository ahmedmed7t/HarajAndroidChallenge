package com.example.harajtask.UI.Details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.data.Model.Post
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var postModel : Post

    private lateinit var postImage    : ImageView
    private lateinit var postTitle    : TextView
    private lateinit var postDate     : TextView
    private lateinit var postLocation : TextView
    private lateinit var postUser     : TextView
    private lateinit var postBody     : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

       initViews()

        val mIntent = intent
        if(mIntent.hasExtra("PostModel")){
            postModel = Gson().fromJson<Post>(mIntent.getStringExtra("PostModel"),Post::class.java)
            showPostData()
        }
    }

    private fun showPostData(){
        postModel.let {
            postTitle.text = it.title
            postBody.text = it.body
            postLocation.text = it.city
            postUser.text = it.username
            Glide.with(this).load(it.thumbURL).into(postImage)
            val format = SimpleDateFormat("yyyy/MM/dd hh:mm aa")
            postDate.text = format.format(Date(it.date))
        }
    }

    private fun initViews(){
        postImage = findViewById(R.id.Details_Post_Image_ImageView)
        postTitle = findViewById(R.id.Details_Post_Title_ImageView)
        postDate  = findViewById(R.id.Details_Post_Date_TextView)
        postLocation = findViewById(R.id.Post_Details_Location_TextView)
        postUser     = findViewById(R.id.Post_Details_User_TextView)
        postBody     = findViewById(R.id.Post_Details_Body_TextView)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    //and this to handle actions
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id: Int = item.getItemId()
        return if (id == R.id.action_share) {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, postModel.title)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
            true
        } else super.onOptionsItemSelected(item)
    }
}