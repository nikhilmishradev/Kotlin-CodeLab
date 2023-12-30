package com.androidtechguru.kotlinpractice.coroutines.flow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androidtechguru.kotlinpractice.coroutines.TAG
import com.androidtechguru.kotlinpractice.coroutines.flow.ui.theme.KotlinConceptsPracticeTheme
import com.androidtechguru.kotlinpractice.ui.activity.ProductListActivity
import com.androidtechguru.kotlinpractice.ui.activity.launchActivity

class FlowActivity : ComponentActivity() {

    private lateinit var flowViewModel: FlowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flowViewModel = ViewModelProvider(this)[FlowViewModel::class.java]

        setContent {
            KotlinConceptsPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val sharedValue by flowViewModel.dataFlow.collectAsState(initial = 0)

                    TextView(sharedValue.toString())
                }
            }
        }

    }

}

@Composable
fun TextView(
    name: String,
    modifier: Modifier = Modifier,
    flowViewModel: FlowViewModel = viewModel()
) {
    val context = LocalContext.current
    val flowValue = flowViewModel.dataFlow.collectAsState(initial = 0)

    Log.v(TAG.verbose, "Shared Value: ${flowValue.value}")

    Column {
        Text(
            text = "Shared Value: $name : ${flowValue.value}",
            modifier = modifier
        )
        Button(onClick = {
            flowViewModel.fetchFlowData()
//            launchActivity(context, ProductListActivity::class.java)
        }) {
            Text(text = "Emit Value fetchFlowData()...")
        }
    }
}
