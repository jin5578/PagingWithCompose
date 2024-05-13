package com.example.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.domain.usecase.system.GetKakaoRestApiKeyUseCase
import com.example.domain.usecase.system.SetKakaoRestApiKeyUseCase
import com.example.presentation.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var getKakaoRestApiKeyUseCase: GetKakaoRestApiKeyUseCase

    @Inject
    lateinit var setKakaoRestApiKeyUseCase: SetKakaoRestApiKeyUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            val isAddedKakaoRestApiKey = !getKakaoRestApiKeyUseCase().isNullOrEmpty()

            if (isAddedKakaoRestApiKey) {
                intentToMain()
            } else {
                val isSucceed = setKakaoRestApiKeyUseCase(KAKAO_REST_API_KEY).isSuccess
                if (isSucceed) {
                    intentToMain()
                }
            }
        }
    }

    private fun intentToMain() {
        MainActivity.startActivity(this)
    }

    companion object {
        val TAG = SplashActivity::class.simpleName
        
        private const val KAKAO_REST_API_KEY = "KakaoAK e64dc07375b3f3320322535c5735e782"
    }
}