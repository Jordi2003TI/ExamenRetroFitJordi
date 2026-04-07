package com.example.examenretrofitjordi

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenretrofitjordi.DataClasses.Material
import com.example.examenretrofitjordi.RecycleView.AdapterRe
import com.example.examenretrofitjordi.Retrofit.Service
import kotlinx.coroutines.launch

class reserves : AppCompatActivity() {
    private lateinit var adapterSync: AdapterRe
    private lateinit var rvReserves: RecyclerView

    private lateinit var adapter: AdapterRe
    private var listaCompleta: List<Material> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reserves)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents();
        initListeners();
        initUI()

        cargarDatosDeLaApi()
    }

    fun initUI(){
        rvReserves.layoutManager = LinearLayoutManager(this)

        adapter = AdapterRe(
            onItemClick = {},
            onDeleteClick = {item, position ->
                lifecycleScope.launch {
                    try{
                        val response = Service.API().deleteMaterialById(item.id)
                        if(response.isSuccessful){
                            cargarDatosDeLaApi()
                        }
                    }catch (e: Exception) {
                        e.printStackTrace()
                        Toast.makeText(
                            this@reserves,
                            "Error de conexión: ${e.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.i("Error", e.message.toString())
                    }
                }
            }
        )

        rvReserves.adapter = adapterSync
    }

    fun initListeners(){

    }

    fun initComponents(){
        rvReserves = findViewById<RecyclerView>(R.id.rvReserves)
    }

    fun cargarDatosDeLaApi(){
        lifecycleScope.launch {
            try {
                val reponse = Service.API().allMaterials()
                if(reponse.isSuccessful){
                    var listaAPI = reponse.body() ?: emptyList<Material>()
                    listaCompleta = listaAPI
                    adapter.updateList(listaCompleta)
                }
            }catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(
                    this@reserves,
                    "Error de conexión: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("Error", e.message.toString())
            }
        }

    }
}