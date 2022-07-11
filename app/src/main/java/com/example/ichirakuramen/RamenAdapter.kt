package com.example.ichirakuramen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RamenAdapter(private val isLinear:Boolean,private val ramenList:List<Ramen>):RecyclerView.Adapter<RamenAdapter.RamenViewHolder>() {
    inner class RamenViewHolder(view: View?):RecyclerView.ViewHolder(view!!){
        val ramenImg : ImageView = view!!.findViewById(R.id.ramen_img)
        val name : TextView = view!!.findViewById(R.id.name)
        val price : TextView = view!!.findViewById(R.id.price)
        fun bind(ramen: Ramen){
            ramenImg.setImageResource(ramen.imageId)
            name.text = ramen.name
            price.text = ramen.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RamenViewHolder {
        val card = if (isLinear) R.layout.ramen_linear else R.layout.ramen_grid
        val layout = LayoutInflater.from(parent.context).inflate(card,parent,false)
        return RamenViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RamenViewHolder, position: Int) {
        holder.bind(ramenList[position])
    }

    override fun getItemCount() = ramenList.size
}