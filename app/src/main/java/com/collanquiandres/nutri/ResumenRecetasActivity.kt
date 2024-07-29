package com.collanquiandres.nutri

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenRecetasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_recetas)

        val selectedRecetas = intent.getParcelableArrayListExtra<Receta>("selectedRecetas")
        if (selectedRecetas != null) {
            var totalCalorias = 0
            var totalProteinas = 0
            var totalCarbohidratos = 0
            var totalGrasas = 0

            for (receta in selectedRecetas) {
                totalCalorias += receta.calorias
                totalProteinas += receta.proteinas
                totalCarbohidratos += receta.carbohidratos
                totalGrasas += receta.grasas
            }

            findViewById<TextView>(R.id.totalCalorias).text = "Total Calorías: $totalCalorias"
            findViewById<TextView>(R.id.totalProteinas).text = "Total Proteínas: $totalProteinas g"
            findViewById<TextView>(R.id.totalCarbohidratos).text = "Total Carbohidratos: $totalCarbohidratos g"
            findViewById<TextView>(R.id.totalGrasas).text = "Total Grasas: $totalGrasas g"

            val barChartView: BarChartView = findViewById(R.id.barChart)
            barChartView.setData(totalCalorias, totalProteinas, totalCarbohidratos, totalGrasas)

            val pieChartView: PieChartView = findViewById(R.id.pieChart)
            pieChartView.setData(totalCalorias, totalProteinas, totalCarbohidratos, totalGrasas)
        }
    }
}
