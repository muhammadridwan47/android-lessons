package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemProfileBinding

class ListProfileAdapter(private val dataProfile: ArrayList<Profile>): RecyclerView.Adapter<ListProfileAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Profile)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemProfileBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = dataProfile.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
            val (name, description, photo) = dataProfile[position]
            holder.binding.imgItemPhoto.setImageResource(photo)
            holder.binding.tvItemDescription.text = description
            holder.binding.tvItemName.text = name
            holder.itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(dataProfile[holder.adapterPosition])
            }
    }
}