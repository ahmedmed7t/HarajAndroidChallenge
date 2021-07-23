package com.advradiuspro.advradiuspro.ui.Profiles.Adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harajtask.R
import com.example.harajtask.Utils.CallBackCaller
import com.example.harajtask.data.Model.Post
import com.squareup.picasso.Picasso
import org.ocpsoft.prettytime.PrettyTime
import java.util.*


class PostRecyclerAdapter(val array : ArrayList<Post>, val callBackCaller: CallBackCaller) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class viewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val postImage              = itemView.findViewById<ImageView>(R.id.Post_List_Item_PostImage_ImageView)
        val postTitle              = itemView.findViewById<TextView>(R.id.Post_List_Item_Title_TextView)
        val date                   = itemView.findViewById<TextView>(R.id.Post_List_Item_Date_TextView)
        val commentCount           = itemView.findViewById<TextView>(R.id.Post_List_Item_Comment_Count_TextView)
        val location               = itemView.findViewById<TextView>(R.id.Post_List_Item_Location_TextView)
        val user                   = itemView.findViewById<TextView>(R.id.Post_List_Item_User_TextView)
        val commentContainer       = itemView.findViewById<LinearLayout>(R.id.Post_List_Item_Comment_Count_Container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val myViewHolder = holder as viewHolder

        //Glide.with(holder.itemView.context).load(array[position].thumbURL).into(myViewHolder.postImage)
        Picasso.get().load(array[position].thumbURL).into(myViewHolder.postImage)

        myViewHolder.postTitle.text = array[position].title
        myViewHolder.location.text = array[position].city
        myViewHolder.user.text = array[position].username

        val p = PrettyTime()
        p.locale = Locale.US
        myViewHolder.date.text = p.format(Date(array[position].date))

        if(array[position].commentCount > 0){
            myViewHolder.commentCount.text = array[position].commentCount.toString()
            myViewHolder.commentContainer.visibility = View.VISIBLE
        }else{
            myViewHolder.commentContainer.visibility = View.INVISIBLE
        }

        myViewHolder.itemView.setOnClickListener {
            callBackCaller.onClick(position)
        }

    }
}