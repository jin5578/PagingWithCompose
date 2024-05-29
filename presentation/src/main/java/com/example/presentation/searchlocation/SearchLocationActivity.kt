package com.example.presentation.searchlocation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.presentation.theme.PagingWithComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagingWithComposeTheme {
                SearchLocationScreen(onBackClick = { finish() })
            }
        }
    }

    companion object {
        private val TAG = SearchLocationActivity::class.simpleName

        private fun getIntent(context: Context): Intent =
            Intent(context, SearchLocationActivity::class.java)

        fun startActivity(context: Context) {
            context.startActivity(getIntent(context))
        }
    }
}