package com.light.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val context: Context) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    private var foods: List<String> = listOf()

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.itemName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val food = foods[position]
        holder.itemName.text = food
    }

    override fun getItemCount(): Int {
        return foods.size
    }

    fun setFoods(newFoods: List<String>) {
        foods = newFoods
        notifyDataSetChanged()
    }
}
