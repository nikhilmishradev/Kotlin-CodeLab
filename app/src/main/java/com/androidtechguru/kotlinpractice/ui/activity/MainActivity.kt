package com.androidtechguru.kotlinpractice.ui.activity

import android.app.Activity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.androidtechguru.kotlinpractice.coroutines.TAG
import com.androidtechguru.kotlinpractice.rxjava.doApiCall
import com.androidtechguru.kotlinpractice.ui.theme.KotlinConceptsPracticeTheme
import com.androidtechguru.kotlinpractice.ui.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import java.time.format.TextStyle

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        checkIsDebugEnabled()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                viewModel.dataFlow.collect {
                    Toast.makeText(this@MainActivity, "Response... ${it.size}", Toast.LENGTH_LONG).show()
                    it.forEach {
                        Log.v(TAG.coroutine, it.title)
                    }
                }
            }
        }
//        viewModel.data.observe(this) {
//            Toast.makeText(this, "Response... ${it.size}", Toast.LENGTH_LONG).show()
//            it.iterator().forEach {
//                Log.v(TAG.verbose, "viewModel observe -> title: ${it.title}")
//            }
//        }

//        viewModel.fetchDataRxJava()
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
                    viewModel.fetchData()

                    Greeting(this.javaClass.simpleName, activity = ProductListActivity::class.java,
                        onClick = {
//                            finish()
                            doApiCall()
                        })
                }
            }
        }
    }

    private fun checkIsDebugEnabled() {
        val developerOption = Settings.Secure.getInt(
            this.contentResolver,
            Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED,
            0
        )
        Toast.makeText(
            this,
            if (developerOption != 0) "Developer Option is ENABLED (ON)" else "Developer Option is DISABLED (OFF)",
            Toast.LENGTH_LONG
        )
            .show()
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    activity: Class<out Activity>,
    onClick: () -> Unit = {}
) {
    val context = LocalContext.current
    Column {
        Text(
            text = "Hello $name!", fontSize = 48.sp,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
            modifier = modifier
                .clickable {
                    launchActivity(context = context, activity)
                }
                .fillMaxSize()
                .fillMaxHeight()
                .weight(1f)
        )
        Text(
            text = "finish()", fontSize = 32.sp,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
            modifier = modifier
                .clickable {
                    onClick()
                }
                .fillMaxSize()
                .fillMaxHeight()
                .weight(1f)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinConceptsPracticeTheme {
//        Greeting("Android")
    }
}

@Composable
fun ComposeDialogBox() {
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Compose Dialog") },
                text = { Text("This is a simple Compose dialog box.") },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}