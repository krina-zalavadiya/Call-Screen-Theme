package com.example.callscreentheme.Adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.callscreentheme.R
import com.example.callscreentheme.SaveThemeActivity
import android.content.Context as Context1

 class ScreenThemeListAdapter(images: Array<Int>) : RecyclerView.Adapter<ScreenThemeListAdapter .ImageHolder>() {
    var images = images

    lateinit var context: Context1

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgitem = itemView.findViewById<ImageView>(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        context = parent.context
        return ImageHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.screenthemelistitem, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return images.size

    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val superHero: Int = images.get(position)

        Glide.with(context).load(images.get(position)).into(holder.imgitem)

        holder.imgitem.setImageResource(superHero);



        holder.imgitem.setOnClickListener {

            val intent = Intent(context, SaveThemeActivity::class.java)
            intent.putExtra("theme",superHero)
            context.startActivity(intent)
        }


    }

}

private fun <T> Array<T>.setImageResource(t: T) {
    TODO("Not yet implemented")
}


