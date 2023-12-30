package com.androidtechguru.kotlinpractice.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.androidtechguru.kotlinpractice.R
import com.androidtechguru.kotlinpractice.coroutines.flow.FlowActivity
import com.androidtechguru.kotlinpractice.databinding.ActivityDataBindingBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class DataBindingActivity : ComponentActivity() {
    private lateinit var binding: ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding.userName = "NIKHIL"

        binding.button.setOnClickListener {
            binding.userName = "You Clicked on Data Binding... Updating from Coroutine"
            Toast.makeText(this, "Button Clicked...", Toast.LENGTH_LONG).show()
            lifecycleScope.launch(Dispatchers.Default) {
                updateDataBinding("NIKHIL MISHRA")
            }
        }
    }

    private suspend fun updateDataBinding(name: String) {
//        delay(500L)
        binding.userName = name
        binding.count++
        launchActivity(this, FlowActivity::class.java)
    }

}