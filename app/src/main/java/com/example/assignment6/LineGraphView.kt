package com.example.assignment6

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class LineGraphView(
    context: Context,
    attrs: AttributeSet? = null,

) : View(context, attrs) {


    private val paint: Paint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

   public var runs = intArrayOf(0, 0, 0, 0)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width
        val height = height

        val maxX = width - 1
        val maxY = height - 1


        val scaleX = maxX.toFloat() / (runs.size - 1)
        val scaleY = maxY.toFloat() / getMaxValue()


      for (i in 0 until runs.size - 1) {
            val x1 = (i * scaleX).toInt()
            val y1 = (maxY - runs[i] * scaleY).toInt()
            val x2 = ((i + 1) * scaleX).toInt()
            val y2 = (maxY - runs[i + 1] * scaleY).toInt()
            canvas.drawCircle(x1.toFloat(), y1.toFloat(), 15f, paint)
            canvas.drawLine(x1.toFloat(), y1.toFloat(), x2.toFloat(), y2.toFloat(), paint)
        }
    }

    private fun getMaxValue(): Int {
        var max = runs[0]
        for (i in 1 until runs.size) {
            if (runs[i] > max) {
                max = runs[i]
            }
        }
        return max
    }
}