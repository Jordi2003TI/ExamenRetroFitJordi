package com.example.examenretrofitjordi.RecycleView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenretrofitjordi.DataClasses.Material
import com.example.examenretrofitjordi.DataClasses.Usuari
import com.example.examenretrofitjordi.R

class AdapterRe (
    private val items: MutableList<Material> = mutableListOf(),
    private val onItemClick: (Material) -> Unit,
    private val onDeleteClick: (Material, Int) -> Unit,
): RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_reserva, parent, false)
        return Holder(view, onItemClick, onDeleteClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun removeItem(position: Int) { //
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateList(newList: List<Material>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}
