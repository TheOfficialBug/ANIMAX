package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Anime

class ItemAdapter(
        private val context: Context,
        private val dataset: List<com.example.affirmations.data.Anime>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private lateinit var itemClickListener: ItemClickListener

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val rating : TextView = view.findViewById(R.id.item_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.title
        holder.rating.text = item.rating
        val imageId = when(item.title) {
            "Naruto" -> R.drawable.naruto
            "Attack On Titan" -> R.drawable.aot
            "Darling In The Franxx" -> R.drawable.ditf
            "Death Note" -> R.drawable.dn
            "Dragon Ball Z" -> R.drawable.dragon
            "Erased" -> R.drawable.erased
            "Fullmetal Alchemist: Brotherhood" -> R.drawable.fullmetal
            "Tokyo Ghoul" -> R.drawable.ghoul
            "Haikyuu!" -> R.drawable.haikyuu
            "Horimiya" -> R.drawable.horimiya
            "Idaten Jump" -> R.drawable.idaten
            "Jujutsu Kaisen" -> R.drawable.jjk
            "One Piece" -> R.drawable.op
            "Naruto Shippuden" -> R.drawable.shippuden
            "Tokyo Revengers" -> R.drawable.tokyo

            else -> R.drawable.animax_logo
        }
        holder.imageView.setImageResource(imageId)
        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(it, position)
        }
    }

    override fun getItemCount() = dataset.size

    fun setItemClickListener(mItemClickListener: ItemClickListener) {
        itemClickListener = mItemClickListener
    }

    interface ItemClickListener{
        fun onItemClick(view: View, position: Int)
    }
    fun getAnime(position: Int) : com.example.affirmations.data.Anime{
        return dataset[position]
    }

}
