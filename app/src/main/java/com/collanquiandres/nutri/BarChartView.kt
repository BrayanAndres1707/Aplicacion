package com.collanquiandres.nutri

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class BarChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var calorias: Int = 0
    private var proteinas: Int = 0
    private var carbohidratos: Int = 0
    private var grasas: Int = 0

    private val barPaint = Paint().apply {
        style = Paint.Style.FILL
    }
    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 40f
        textAlign = Paint.Align.CENTER
    }
    private val axisPaint = Paint().apply {
        color = Color.BLACK
        textSize = 30f
    }

    fun setData(calorias: Int, proteinas: Int, carbohidratos: Int, grasas: Int) {
        this.calorias = calorias
        this.proteinas = proteinas
        this.carbohidratos = carbohidratos
        this.grasas = grasas
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val total = calorias + proteinas + carbohidratos + grasas
        if (total == 0) return

        val barWidth = width / 5f
        val maxHeight = height * 0.7f
        val scale = maxHeight / total

        val barData = listOf(calorias, proteinas, carbohidratos, grasas)
        val labels = listOf("Calorías", "Proteínas", "Carbohidratos", "Grasas")

        for (i in barData.indices) {
            val barHeight = barData[i] * scale
            val left = (i + 1) * barWidth
            val top = height - barHeight
            val right = left + barWidth
            val bottom = height.toFloat()

            barPaint.color = when (i) {
                0 -> Color.RED
                1 -> Color.GREEN
                2 -> Color.YELLOW
                3 -> Color.BLUE
                else -> Color.GRAY
            }

            canvas.drawRect(left, top, right, bottom, barPaint)
            canvas.drawText(barData[i].toString(), left + barWidth / 2, top - 10, textPaint)
            canvas.drawText(labels[i], left + barWidth / 2, bottom + 30, axisPaint)
        }
    }
}
