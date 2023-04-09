package com.example.colorpickerwheel

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class ColorWheelView@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // get the dimensions of the view
        val width = width
        val height = height

        // create a new paint for the color wheel
        val paint = Paint()
        paint.style = Paint.Style.FILL

        // create a new gradient for the color wheel
        val colors = intArrayOf(
            Color.RED,
            Color.YELLOW,
            Color.GREEN,
            Color.CYAN,
            Color.BLUE,
            Color.MAGENTA,
            Color.RED
        )
        val positions = floatArrayOf(0f, 1f / 6, 2f / 6, 3f / 6, 4f / 6, 5f / 6, 1f)
        val gradient = SweepGradient(width / 2f, height / 2f, colors, positions)

        // set the gradient on the paint and draw a circle for the color wheel
        paint.shader = gradient
        canvas.drawCircle(width / 2f, height / 2f, width / 2f, paint)
    }

}