package com.collanquiandres.nutri

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class RecetaDetailActivity : AppCompatActivity() {

    private lateinit var recetaImagen: ImageView
    private lateinit var recetaNombre: TextView
    private lateinit var recetaIngredientes: TextView
    private lateinit var recetaPreparacion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receta_detail)

        recetaImagen = findViewById(R.id.recetaImagen)
        recetaNombre = findViewById(R.id.recetaNombre)
        recetaIngredientes = findViewById(R.id.recetaIngredientes)
        recetaPreparacion = findViewById(R.id.recetaPreparacion)

        val nombre = intent.getStringExtra("nombre")
        val imagenUrl = intent.getStringExtra("imagenUrl")
        val ingredientes = intent.getStringExtra("ingredientes")
        val preparacion = intent.getStringExtra("preparacion")

        recetaNombre.text = nombre
        Picasso.get().load(imagenUrl).into(recetaImagen)
        recetaIngredientes.text = ingredientes
        recetaPreparacion.text = preparacion
    }
}
