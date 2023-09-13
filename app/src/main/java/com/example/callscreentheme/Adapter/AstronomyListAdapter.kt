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

class AstronomyListAdapter(astroimg: Array<Int>) : RecyclerView.Adapter<AstronomyListAdapter.AstroListHolder>() {

    var astroimg = astroimg
    lateinit var context: Context
    class AstroListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgitem4 = itemView.findViewById<ImageView>(R.id.img4)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstroListHolder {
        context = parent.context
        return AstroListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.astrolistitem, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return astroimg.size
    }

    override fun onBindViewHolder(holder: AstroListHolder, position: Int) {
        val superHero: Int = astroimg.get(position)

        Glide.with(context).load(astroimg.get(position)).into(holder.imgitem4)

        holder.imgitem4.setImageResource(superHero);

        holder.imgitem4.setOnClickListener {
            val intent = Intent(context, SaveThemeActivity::class.java)
            intent.putExtra("theme",superHero)
            context.startActivity(intent)
        }
    }
    }
