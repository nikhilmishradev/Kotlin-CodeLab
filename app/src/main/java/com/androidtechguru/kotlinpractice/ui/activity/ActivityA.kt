package com.androidtechguru.kotlinpractice.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.androidtechguru.kotlinpractice.ui.theme.KotlinConceptsPracticeTheme

class ActivityA : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinConceptsPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(this.javaClass.simpleName, activity = MainActivity::class.java,
                        onClick = {
//                            finishAffinity()
//                            finishAfterTransition()
//                            finish()
                            finishAndRemoveTask()
                        })
                }
            }
        }
    }


}