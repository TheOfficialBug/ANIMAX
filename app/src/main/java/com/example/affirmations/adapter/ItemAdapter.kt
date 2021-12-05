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
        private val dataset: List<Anime>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

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
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.rating.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
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
    fun getAnime(position: Int) : Anime{
        return dataset[position]
    }

}
