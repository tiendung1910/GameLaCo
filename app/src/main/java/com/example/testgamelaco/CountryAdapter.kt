package com.example.testgamelaco

import android.content.Context
import android.view.ContentInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(val context: Context,val countryList: List<CountryInfo>)
    : RecyclerView.Adapter<CountryAdapter.ViewHolder>(){

    var onItemClick: ((CountryInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.country_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name_id.text = countryList[position].name
        holder.population.text = "${countryList[position].population} millions"
        holder.flag_id.setImageResource(countryList[position].imageResourceID)

    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val flag_id = view.findViewById<ImageView>(R.id.flag)
        val name_id = view.findViewById<TextView>(R.id.name_item)
        val population = view.findViewById<TextView>(R.id.population_item)

        init {
            view.setOnClickListener {
                onItemClick?.invoke(countryList[adapterPosition])
            }
        }

    }
}