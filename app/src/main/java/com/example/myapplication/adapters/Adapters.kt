package com.example.myapplication2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.model.Item
import com.example.myapplication2.R

class Adapters(var context: Context, var arrayList: ArrayList<Item>) :
    RecyclerView.Adapter<Adapters.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        val itemHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_image, parent, false)
        return ItemHolder(itemHolder)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val item:Item = arrayList.get(position)

        holder.icons.setImageResource(item.icons!!)
        holder.titles.text = item.alpha

        holder.titles.setOnClickListener {
            Toast.makeText(context, item.alpha, Toast.LENGTH_LONG).show()
        }

        holder.titles.setOnClickListener {
            Toast.makeText(context,"You click Wheel", Toast.LENGTH_SHORT).show()
        }


    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var icons = itemView.findViewById<ImageView>(R.id.item_image)
        var titles = itemView.findViewById<TextView>(R.id.text_tittle)
    }
}