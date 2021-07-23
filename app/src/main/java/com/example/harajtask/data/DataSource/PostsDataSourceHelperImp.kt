package com.advradiuspro.advradiuspro.data.api.DashboardApi

import android.content.Context
import com.example.harajtask.data.Model.Post
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class PostsDataSourceHelperImp(val context: Context) : PostsDataSourceHelper{
    override fun getUserDetails(): List<Post>? {
        val result : String = loadJSONFromAsset(context) ?: ""
        if(result.isNotEmpty()){
            val posts  : List<Post> = Gson().fromJson(result, Array<Post>::class.java).asList()
            return posts
        }
        return null
    }

    fun loadJSONFromAsset(context: Context): String? {
        var json: String? = null
        json = try {
            val inputStream: InputStream = context.getAssets().open("data.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, Charset.defaultCharset())
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

}