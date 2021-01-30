package com.example.myapplication2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val dataArray: ArrayList<DatabaseRow>)
    :RecyclerView.Adapter<Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.client_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataArray.size
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {

        holder.imieTV.text = dataArray[holder.adapterPosition].imie
        holder.nazwiskoTV.text = dataArray[holder.adapterPosition].nazwisko

        val databaseRow:DatabaseRow = dataArray.get(position)
        holder.imieTV.text = databaseRow.imie
        holder.nazwiskoTV.text = databaseRow.nazwisko

    }

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imieTV = view.findViewById(R.id.imieTV) as TextView
        val nazwiskoTV = view.findViewById(R.id.nazwiskoTV) as TextView
    }
}

/*
class Adapters(var context: Context, var arrayList: ArrayList<DatabaseRow>):
        RecyclerView.Adapter<Adapters.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.client_row,parent,false)

        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val databaseRow:DatabaseRow = arrayList.get(position)

        holder.imieTV.text = databaseRow.imie
        holder.nazwiskoTV.text = databaseRow.nazwisko

    }

    class ItemHolder(databaseRowView: View): RecyclerView.ViewHolder(databaseRowView){
        val imieTV = databaseRowView.findViewById(R.id.imieTV) as TextView
        val nazwiskoTV = databaseRowView.findViewById(R.id.nazwiskoTV) as TextView
    }
}
 */

