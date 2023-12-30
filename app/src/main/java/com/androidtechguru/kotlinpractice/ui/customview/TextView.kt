package com.androidtechguru.kotlinpractice.ui.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.compose.ui.text.TextStyle
import com.androidtechguru.kotlinpractice.R
import android.graphics.Typeface
import androidx.appcompat.widget.AppCompatTextView

class TextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var showText: Boolean = true
    private var isHeader: Boolean = true
    private var textColor: Int = resources.getColor(android.R.color.black, context.theme)
    private var textBold: Boolean = false

    init {
        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.TextView, defStyleAttr, 0
        )

        showText = typedArray.getBoolean(R.styleable.TextView_showText, true)
        isHeader = typedArray.getBoolean(R.styleable.TextView_header, false)
        textColor = typedArray.getColor(
            R.styleable.TextView_textColor,
            resources.getColor(android.R.color.black, context.theme)
        )
        textBold = typedArray.getBoolean(R.styleable.TextView_bold, false)

        typedArray.recycle()
        applyAttributes()
    }


    private fun applyAttributes() {
        // Set visibility based on showText attribute
        visibility = if (showText) VISIBLE else GONE

        // Set text appearance based on isHeader attribute
        if (isHeader) {
            // Apply header style
            // Example: Set header text size, color, etc.
            textSize = 32f // Set header text size (modify as needed)
            setTypeface(null, Typeface.BOLD)
            textColor =  resources.getColor(android.R.color.holo_red_dark, context.theme)
        }else{
            textSize=16f
        }

        // Set text color
        setTextColor(textColor)

        // Set text boldness based on textBold attribute
        if (textBold) {
            setTypeface(null, Typeface.BOLD)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
    }

}