package com.yuyakaido.android.cardstackview.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CardStackAdapter(
        private var spots: List<Spot> = emptyList(),private val bottomClikListener: BottomClickListener
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    interface BottomClickListener{
        fun likeClick()

        fun nextClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_spot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]
        holder.name.text = "${spot.id}. ${spot.name}"
        holder.city.text = spot.city
        Glide.with(holder.image)
                .load(spot.url)
                .into(holder.image)
        holder.likeBtn.setOnClickListener {
            bottomClikListener.likeClick()
        }
        holder.nextBtn.setOnClickListener {
            bottomClikListener.nextClick()
        }
        holder.itemView.setOnClickListener { v ->
            Toast.makeText(v.context, spot.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<Spot>) {
        this.spots = spots
    }

    fun getSpots(): List<Spot> {
        return spots
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_name)
        var city: TextView = view.findViewById(R.id.item_city)
        var image: ImageView = view.findViewById(R.id.item_image)
        val nextBtn: FloatingActionButton = view.findViewById(R.id.nextBtn)
        val likeBtn: FloatingActionButton = view.findViewById(R.id.likeBtn)

    }

}
