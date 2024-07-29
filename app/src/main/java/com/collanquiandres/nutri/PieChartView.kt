package com.collanquiandres.nutri

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.min
import kotlin.math.cos
import kotlin.math.sin

class PieChartView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var calorias: Int = 0
    private var proteinas: Int = 0
    private var carbohidratos: Int = 0
    private var grasas: Int = 0

    private val piePaint = Paint().apply {
        style = Paint.Style.FILL
    }
    private val textPaint = Paint().apply {
        color = Color.BLACK
        textSize = 30f
        textAlign = Paint.Align.CENTER
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

        val colors = listOf(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE)
        val values = listOf(calorias, proteinas, carbohidratos, grasas)

        val centerX = width / 2f
        val centerY = height / 2f
        val radius = min(width, height) / 2f * 0.8f

        var startAngle = 0f
        for (i in values.indices) {
            val sweepAngle = (values[i] / total.toFloat()) * 360f
            piePaint.color = colors[i]
            canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, startAngle, sweepAngle, true, piePaint)

            // Calculate the label position
            val angle = startAngle + sweepAngle / 2
            val labelX = centerX + radius / 2 * cos(Math.toRadians(angle.toDouble())).toFloat()
            val labelY = centerY + radius / 2 * sin(Math.toRadians(angle.toDouble())).toFloat()

            // Draw the percentage
            canvas.drawText("${(values[i] / total.toFloat() * 100).toInt()}%", labelX, labelY, textPaint)

            startAngle += sweepAngle
        }
    }
}
