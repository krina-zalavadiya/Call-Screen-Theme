package com.example.callscreentheme.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.callscreentheme.R
import com.example.callscreentheme.SaveThemeActivity


class NatureListAdapter(natureimg: Array<Int>) : RecyclerView.Adapter<NatureListAdapter.NatureListHolder>() {

    var natureimg = natureimg
    lateinit var context: Context
    class NatureListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgitem5 = itemView.findViewById<ImageView>(R.id.img5)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NatureListHolder {
        context = parent.context
        return NatureListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.naturelistitem, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return natureimg.size
    }

    override fun onBindViewHolder(holder: NatureListHolder, position: Int) {
        val superHero: Int = natureimg.get(position)

        Glide.with(context).load(natureimg.get(position)).into(holder.imgitem5)

        holder.imgitem5.setImageResource(superHero);

        holder.imgitem5.setOnClickListener {
            val intent = Intent(context, SaveThemeActivity::class.java)
            intent.putExtra("theme",superHero)
            context.startActivity(intent)
        }
    }
    }
