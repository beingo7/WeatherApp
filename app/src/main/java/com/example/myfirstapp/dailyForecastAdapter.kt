package com.example.myfirstapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class dailyForecastViewHolder(view:View):RecyclerView.ViewHolder(view){

    private val tempText:TextView=view.findViewById(R.id.tempText)
    private val descriptionText:TextView=view.findViewById(R.id.descriptionText)  //what we did here is import textviews from xml file into adapter

    fun bind(dailyForecast: dailyForecast){
        tempText.text= String.format("%.2f",dailyForecast.temp)
        descriptionText.text=dailyForecast.description
    }
}


class dailyForecastAdapter(
    private val clickHandler:(dailyForecast)-> Unit

): ListAdapter<dailyForecast,dailyForecastViewHolder>(DIFF_COFIG) { //listadapter takes two parameters: type of item,    view holder


    companion object{
        val DIFF_COFIG=object :DiffUtil.ItemCallback<dailyForecast>(){
            override fun areItemsTheSame(oldItem: dailyForecast, newItem: dailyForecast): Boolean {
                return oldItem===newItem  ///3 equals tells if they are exsct same reference
            }

            override fun areContentsTheSame(
                oldItem: dailyForecast,
                newItem: dailyForecast
            ): Boolean {
                return oldItem==newItem    //2 equals will return true if contents of item are same(objdoesn't have to be same)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dailyForecastViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_daily_forecast,parent,false)
        return dailyForecastViewHolder(itemView)
        
    }

    override fun onBindViewHolder(holder: dailyForecastViewHolder, position: Int) {

        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clickHandler(getItem(position))
        }
    }
}