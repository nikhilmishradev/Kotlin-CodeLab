package com.androidtechguru.kotlinpractice.ui.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidtechguru.kotlinpractice.R
import com.androidtechguru.kotlinpractice.ui.activity.BaseActivity

class CustomViewActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)

        // Inside your Activity's onCreate or any lifecycle method
        val waterFillView = WaterFillView(this)
        waterFillView.setWaterLevel(0.5f) // Set water level to 50%
        // Add waterFillView to your layout

    }
}