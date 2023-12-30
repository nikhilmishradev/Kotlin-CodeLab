package com.androidtechguru.kotlinpractice.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.androidtechguru.kotlinpractice.R

class WaterFillView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val containerPaint = Paint()
    private val waterPaint = Paint()

    private var waterLevel = 0f
    private var containerColor = Color.GRAY
    private var waterColor = ContextCompat.getColor(context, R.color.blue) // Assuming 'blue' color is defined in your resources

    init {
        containerPaint.color = containerColor
        containerPaint.style = Paint.Style.FILL

        waterPaint.color = waterColor
        waterPaint.style = Paint.Style.FILL

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Draw the container (rectangular shape)
        canvas.drawRect(50f, 50f, width - 50f, height - 50f, containerPaint)

        // Calculate and draw the water level (blue rectangle) within the container
        val waterHeight = (height - 100) * waterLevel // Calculate water height
        canvas.drawRect(50f, height - waterHeight - 50f, width - 50f, height - 50f, waterPaint)
    }

    fun setWaterLevel(level: Float) {
        // Set the water level between 0 to 1 (0% to 100%)
        waterLevel = level.coerceIn(0f,1f)
        waterLevel = (height - 100) * (100 - level) / 100f
        invalidate() // Redraw the view with the new water level
    }
}
