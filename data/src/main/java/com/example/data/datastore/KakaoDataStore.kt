package com.example.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.datastore by preferencesDataStore(name = "kakao_data_store")

class KakaoDataStore @Inject constructor(
    private val context: Context
) {
    suspend fun setRestApiKey(key: String) {
        context.datastore.edit { pref ->
            pref[REST_API_KEY] = key
        }
    }

    suspend fun getRestApiKey(): String? {
        return context.datastore.data.map { it[REST_API_KEY] }.firstOrNull()
    }

    suspend fun clear() {
        context.datastore.edit { pref ->
            pref.clear()
        }
    }

    companion object {
        private val REST_API_KEY = stringPreferencesKey("restApiKey")
    }
}