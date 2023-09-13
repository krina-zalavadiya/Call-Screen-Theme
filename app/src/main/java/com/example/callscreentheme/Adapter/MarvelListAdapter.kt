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


class MarvelListAdapter(marvelimg: Array<Int>) : RecyclerView.Adapter<MarvelListAdapter.MarvelListHolder>() {

    var marvelimg = marvelimg
    lateinit var context: Context
    class MarvelListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgitem3 = itemView.findViewById<ImageView>(R.id.img3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelListHolder {
        context = parent.context
        return MarvelListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.marvellistitem, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return marvelimg.size
    }

    override fun onBindViewHolder(holder: MarvelListHolder, position: Int) {
        val superHero: Int = marvelimg.get(position)

        Glide.with(context).load(marvelimg.get(position)).into(holder.imgitem3)

        holder.imgitem3.setImageResource(superHero);

        holder.imgitem3.setOnClickListener {
            val intent = Intent(context, SaveThemeActivity::class.java)
            intent.putExtra("theme",superHero)
            context.startActivity(intent)
        }
    }    }
