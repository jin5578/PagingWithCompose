package com.example.presentation.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@OptIn(OrbitExperimental::class)
@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel(), ContainerHost<MainScreenState, MainScreenSideEffect> {
    override val container: Container<MainScreenState, MainScreenSideEffect> = container(
        initialState = MainScreenState(),
        buildSettings = {
            this.exceptionHandler = CoroutineExceptionHandler { _, throwable ->
                intent {
                    postSideEffect(
                        MainScreenSideEffect.Toast(
                            message = throwable.message.orEmpty()
                        )
                    )
                }
            }
        }
    )

    fun onTextChange(keyword: String) = blockingIntent {
        reduce { state.copy(keyword = keyword) }
    }
}

@Immutable
data class MainScreenState(
    val keyword: String = ""
)

sealed interface MainScreenSideEffect {
    class Toast(val message: String) : MainScreenSideEffect
}