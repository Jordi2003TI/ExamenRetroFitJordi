package com.example.examenretrofitjordi.RecycleView

import android.media.Image
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examenretrofitjordi.DataClasses.Material
import com.example.examenretrofitjordi.DataClasses.Usuari
import com.example.examenretrofitjordi.R

class Holder (
    itemView: View,
    private val onItemClick: (Material) -> Unit,
    private val onDeleteClick: (Material, Int) -> Unit,
): RecyclerView.ViewHolder(itemView){

    private val ivMaterial: ImageView = itemView.findViewById(R.id.ivMaterial)
    private val tvDescripcio: TextView = itemView.findViewById(R.id.tvDescripcio)
    private val tvDates: TextView = itemView.findViewById(R.id.tvDates)
    private val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    fun bind(item: Material){

        tvDescripcio.text = "item.descripcio.toString()"
        tvDates.text = ""

        ivMaterial.setImageResource(R.drawable.ic_user)
        btnDelete.setImageResource(R.drawable.ic_trash)

        itemView.setOnClickListener {
            onItemClick(item)
        }

        btnDelete.setOnClickListener { // La imagen se commporta como un boton
            val position = bindingAdapterPosition // Esto coge la posicion es propia de kotlin
            if (position != RecyclerView.NO_POSITION) {
                onDeleteClick(
                    item,
                    position
                ) // Esto es para ELIMINAR el reciclerView al editar un item (Funcion delarada en el adapater)
            }

        }
    }
}