package com.example.callscreentheme.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.callscreentheme.Model.NeonListModel
import com.example.callscreentheme.R
import com.example.callscreentheme.SaveThemeActivity
import com.example.callscreentheme.ScreenThemeActivity
import android.content.Context as Context1


class NeonListAdapter(neonimg: Array<Int>) : RecyclerView.Adapter<NeonListAdapter.NeonListHolder>() {

    var neonimg = neonimg
    lateinit var context: Context1
    class NeonListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgitem1 = itemView.findViewById<ImageView>(R.id.img1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NeonListHolder {
        context = parent.context
        return NeonListHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.screenthemelistitem, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return neonimg.size
    }

    override fun onBindViewHolder(holder: NeonListHolder, position: Int) {
        val superHero: Int = neonimg.get(position)

        Glide.with(context).load(neonimg.get(position)).into(holder.imgitem1)

        holder.imgitem1.setImageResource(superHero);

        holder.imgitem1.setOnClickListener {
            val intent = Intent(context,SaveThemeActivity::class.java)
            intent.putExtra("theme",superHero)
            context.startActivity(intent)
        }
    }
}