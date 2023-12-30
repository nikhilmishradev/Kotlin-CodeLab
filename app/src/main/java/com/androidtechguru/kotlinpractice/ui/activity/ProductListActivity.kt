package com.androidtechguru.kotlinpractice.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidtechguru.kotlinpractice.coroutines.TAG
import com.androidtechguru.kotlinpractice.services.MyForegroundService
import com.androidtechguru.kotlinpractice.ui.activity.ui.theme.KotlinConceptsPracticeTheme
import com.androidtechguru.kotlinpractice.ui.compose.ProductListView
import com.androidtechguru.kotlinpractice.ui.viewmodel.MainViewModel

class ProductListActivity : ComponentActivity() {
    lateinit var productViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productViewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        productViewModel.fetchData()

        setContent {
            KotlinConceptsPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val count = intent.getIntExtra("data", 0)
                    ProductScreenUI(productViewModel, count)
                }
                getSharedPreferences("",0).edit().apply()
            }
        }
    }
}

@Composable
fun ProductScreenUI(productViewModel: MainViewModel = viewModel(), count: Int = 0) {
    val productList by productViewModel.productList

    val context = LocalContext.current
    android.util.Log.v(TAG.verbose, "count: $count")

    LaunchedEffect(true) {
//        if (count == 0) {
//            android.util.Log.v(TAG.verbose, "count: $count")
//            productViewModel.fetchData()
//        } else
//            android.util.Log.v(TAG.verbose, "count: $count")
        productViewModel.fetchData()
    }

    Text(text = "Next Screen",
        Modifier.clickable {
//            launchActivity(
//                context = context,
//                ProductListActivity::class.java,
//                key = count + 1
//            )
            val serviceIntent = Intent(context,MyForegroundService::class.java)
            ContextCompat.startForegroundService(context, serviceIntent)
        })
    ProductListView(products = productList)
}