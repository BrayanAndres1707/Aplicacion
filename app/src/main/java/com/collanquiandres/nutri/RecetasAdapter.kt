package com.collanquiandres.nutri

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecetasAdapter(private val recetas: List<Receta>, private val context: Context) : RecyclerView.Adapter<RecetasAdapter.ViewHolder>() {

    private val selectedRecetas = mutableListOf<Receta>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.recetaNombre)
        val porcionesTextView: TextView = view.findViewById(R.id.recetaPorciones)
        val imagenImageView: ImageView = view.findViewById(R.id.recetaImagen)
        val infoNutricionalTextView: TextView = view.findViewById(R.id.infoNutricional)
        val selectImageView: ImageView = view.findViewById(R.id.selectImageView)

        var isChecked = false

        fun bind(receta: Receta, context: Context, selectedRecetas: MutableList<Receta>) {
            nombreTextView.text = receta.nombre
            porcionesTextView.text = "Porciones: ${receta.porciones}"
            Picasso.get().load(receta.imagenUrl).into(imagenImageView)

            itemView.setOnClickListener {
                val intent = Intent(context, RecetaDetailActivity::class.java).apply {
                    putExtra("nombre", receta.nombre)
                    putExtra("imagenUrl", receta.imagenUrl)
                    putExtra("ingredientes", receta.ingredientes)
                    putExtra("preparacion", receta.preparacion)
                }
                context.startActivity(intent)
            }

            infoNutricionalTextView.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Información Nutricional")
                builder.setMessage("Calorías: ${receta.calorias}\nProteínas: ${receta.proteinas}g\nCarbohidratos: ${receta.carbohidratos}g\nGrasas: ${receta.grasas}g")
                builder.setPositiveButton("Cerrar") { dialog, _ -> dialog.dismiss() }
                builder.show()
            }

            selectImageView.setOnClickListener {
                isChecked = !isChecked
                selectImageView.setImageResource(if (isChecked) R.drawable.ic_check else R.drawable.ic_unchecked)
                if (isChecked) {
                    selectedRecetas.add(receta)
                } else {
                    selectedRecetas.remove(receta)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(recetas[position], context, selectedRecetas)
    }

    override fun getItemCount(): Int {
        return recetas.size
    }

    fun getSelectedRecetas(): List<Receta> {
        return selectedRecetas
    }
}
