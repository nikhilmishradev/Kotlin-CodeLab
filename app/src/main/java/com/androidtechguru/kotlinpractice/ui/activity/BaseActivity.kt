package com.androidtechguru.kotlinpractice.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Log.VERBOSE
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.androidtechguru.kotlinpractice.oops.classes.UserData
import com.androidtechguru.kotlinpractice.rxjava.doApiCall
import java.lang.ref.WeakReference
import kotlin.reflect.KClass

open class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Log.v(
//            "VERBOSE",
//            "Base Activity Class -> ${"packageName: " + this.packageName + "componentName: " + this.componentName + "localClassName: " + this.localClassName}"
//        )
        "VERBOSE" Log ("onCreate()*** -> ".simpleName(this@BaseActivity))
        WeakReference(UserData(""))
    }

    override fun onStart() {
        super.onStart()
        Log("onStart()--- -> ".simpleName(this))

    }

    override fun onResume() {
        super.onResume()
        Log("onResume()... -> ".simpleName(this))
    }

    override fun onPause() {
        super.onPause()
        "VERBOSE" Log ("onPause()... -> ".simpleName(this))

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log("onSaveInstanceState()... --->>>".simpleName(this))
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log("onNewIntent()... --->>>".simpleName(this))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log("onRestoreInstanceState()... --->>>".simpleName(this))
    }

    override fun onStop() {
        super.onStop()
        Log("onStop()xxx -> ".simpleName(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log("onDestroy()... -> ".simpleName(this))
    }

    override fun onRestart() {
        super.onRestart()
        Log("onRestart()... -> ".simpleName(this))
    }


}

fun String.simpleName(context: Context) = this + context.javaClass.simpleName
infix fun String.Log(message: String) {
    Log.v(this, message)
}

fun Log(message: String) {
    Log.v("VERBOSE", message)
}

fun launchActivity(context: Context, nextActivity: Class<out Activity>, key: Int = 0) {
    Log("launchActivity: ${"".simpleName(context)} --->>> ${nextActivity.simpleName}")
    val intent = Intent(context, nextActivity)
    intent.putExtra("data", key)
    context.startActivity(intent)
    doApiCall()

    // 5 methods called
    // onfinish() 6 methods called
}

