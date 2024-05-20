package com.example.data

import androidx.test.platform.app.InstrumentationRegistry
import com.example.data.database.datastore.KakaoDataStore
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

private const val expectedKey = "key"

class KakaoDataStoreTest {
    private lateinit var kakaoDataStore: KakaoDataStore

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        kakaoDataStore = KakaoDataStore(context)
    }

    @Test
    fun 카카오_키_저장_테스트() = runTest {
        kakaoDataStore.setRestApiKey(expectedKey)
        val restApiKey = kakaoDataStore.getRestApiKey()
        Assert.assertEquals(expectedKey, restApiKey)
    }

    @Test
    fun 카카오_키_초기화_테스트() = runTest {
        kakaoDataStore.clear()
        val restApiKey = kakaoDataStore.getRestApiKey()
        Assert.assertNotEquals(expectedKey, restApiKey)
        Assert.assertNull(restApiKey)
    }
}