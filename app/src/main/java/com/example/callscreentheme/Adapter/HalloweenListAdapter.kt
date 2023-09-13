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


class HalloweenListAdapter(hallimg: Array<Int>) : RecyclerView.Adapter<HalloweenListAdapter.HalloweenListHolder>() {

    var hallimg = hallimg
    lateinit var context: Context
    class HalloweenListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgitem2 = itemView.findViewById<ImageView>(R.id.img2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HalloweenListHolder {
        context = parent.context
        return HalloweenListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.halloweenlistitem, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return hallimg.size
    }

    override fun onBindViewHolder(holder: HalloweenListHolder, position: Int) {
        val superHero: Int = hallimg.get(position)

        Glide.with(context).load(hallimg.get(position)).into(holder.imgitem2)

        holder.imgitem2.setImageResource(superHero);

        holder.imgitem2.setOnClickListener {
            val intent = Intent(context, SaveThemeActivity::class.java)
            intent.putExtra("theme",superHero)
            context.startActivity(intent)
        }
    }
    }
