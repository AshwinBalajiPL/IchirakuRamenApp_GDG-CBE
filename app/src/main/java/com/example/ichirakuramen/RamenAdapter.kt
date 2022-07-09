package com.example.ichirakuramen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ichirakuramen.databinding.RamenListBinding

class RamenAdapter(private val ramenList:List<Ramen>):RecyclerView.Adapter<RamenAdapter.RamenViewHolder>() {
    inner class RamenViewHolder(private val binding : RamenListBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(ramen: Ramen){
            binding.ramenImg.setImageResource(ramen.imageId)
            binding.name.text = ramen.name
            binding.price.text = ramen.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RamenViewHolder {
        return RamenViewHolder(RamenListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RamenViewHolder, position: Int) {
        holder.bind(ramenList[position])
    }

    override fun getItemCount() = ramenList.size
}