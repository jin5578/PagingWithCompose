package com.example.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.theme.PagingWithComposeTheme
import com.example.presentation.searchlocation.SearchLocationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagingWithComposeTheme {
                MainNavHost(
                    onSearchClick = { intentToSearchLocation() }
                )
            }
        }
    }

    private fun intentToSearchLocation() {
        SearchLocationActivity.startActivity(this)
    }

    companion object {
        private fun getIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }

        fun startActivity(context: Context) {
            context.startActivity(getIntent(context))
        }
    }
}