package com.example.proyectofinalv1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinalv1.io.ApiService
import com.example.proyectofinalv1.model.Piece
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val apiService: ApiService by lazy {
        ApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun cargarDatos(){
        val respuesta = apiService.listar()

        respuesta.enqueue(object: Callback<ArrayList<Piece>> {
            override fun onFailure(call: Call<ArrayList<Piece>>, t: Throwable) {
                TODO("Not yet implemented")
                Toast.makeText(this@MainActivity, getString(R.string.error_carga_datos), Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<Piece>>,
                response: Response<ArrayList<Piece>>
            ) {
                TODO("Not yet implemented")
                if(response.isSuccessful) {
                    showData(response.body()!!)
                }
            }

        })


    }

    private fun showData(pieces: List<Piece>){
        recyclerView.apply {
            RecyclerView.LayoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PieceAdapter(pieces)
        }
    }
}