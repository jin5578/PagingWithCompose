package com.example.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.presentation.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            launch {
                delay(DELAY_TIME_MILLIS)
            }.join()

            intentToMain()
        }
    }

    private fun intentToMain() {
        MainActivity.startActivity(this)
    }

    companion object {
        const val DELAY_TIME_MILLIS = 300L
    }
}