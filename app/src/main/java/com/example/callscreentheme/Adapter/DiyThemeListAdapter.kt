package com.example.callscreentheme.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.callscreentheme.R
import android.content.Context as Context1

class DiyThemeListAdapter(diyimg: Array<Int>): RecyclerView.Adapter<DiyThemeListAdapter.DiylistHolder>() {

    var diyimg = diyimg
    lateinit var context: Context1

    class DiylistHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var diyimgitem = itemView.findViewById<ImageView>(R.id.diyimg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiylistHolder {
        context = parent.context
        return DiylistHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.diythemelistitem,parent,false)
        )
    }

    override fun getItemCount(): Int {

        return diyimg.size
    }

    override fun onBindViewHolder(holder: DiylistHolder, position: Int) {
        Glide.with(context).load(diyimg.get(position)).into(holder.diyimgitem)
    }

}