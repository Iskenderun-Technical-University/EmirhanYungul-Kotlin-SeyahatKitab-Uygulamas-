package com.example.kotlin_haritalar.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.kotlin_haritalar.databinding.RecyclerRowBinding
import com.example.kotlin_haritalar.view.MapsActivity
import com.example.kotlin_haritalar.yer


class placeAdapter(val placelist : List<yer>) : RecyclerView.Adapter<placeAdapter.PlaceHolder>(){

   class PlaceHolder(val recyclerRowBinding: RecyclerRowBinding) : RecyclerView.ViewHolder(recyclerRowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaceHolder(recyclerRowBinding)
    }

    override fun getItemCount(): Int {
        return placelist.size
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
            holder.recyclerRowBinding.recyclerViewtextview.text=placelist.get(position).name
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context,MapsActivity::class.java)
                intent.putExtra("selectedPlace",placelist.get(position))
                intent.putExtra("info","old")
                holder.itemView.context.startActivity(intent)
            }
    }

}