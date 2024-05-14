package com.example.presentation.main

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.map
import com.example.domain.usecase.main.SearchKeywordUseCase
import com.example.domain.usecase.room.DeletePlaceUseCase
import com.example.domain.usecase.room.FindPlaceIdListUseCase
import com.example.domain.usecase.room.InsertPlaceUseCase
import com.example.presentation.model.LocationUIModel
import com.example.presentation.model.toDomainModel
import com.example.presentation.model.toUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
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
    private val searchKeywordUseCase: SearchKeywordUseCase,
    private val insertPlaceUseCase: InsertPlaceUseCase,
    private val findPlaceIdListUseCase: FindPlaceIdListUseCase,
    private val deletePlaceUseCase: DeletePlaceUseCase
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

    init {
        loadBookmarkPlaceIdList()
    }

    fun onTextChange(keyword: String) = blockingIntent {
        reduce { state.copy(keyword = keyword) }

        if (keyword.isNotBlank()) {
            loadLocation(state.keyword)
        } else {
            reduce { state.copy(locationUIModelFlow = emptyFlow()) }
        }
    }

    private fun loadLocation(keyword: String) = intent {
        val locationFlow = searchKeywordUseCase(keyword).getOrThrow()
        val locationUIModelFlow = locationFlow.map { pagingData ->
            pagingData.map { location ->
                location.toUIModel()
            }
        }
        reduce { state.copy(locationUIModelFlow = locationUIModelFlow) }
    }

    private fun loadBookmarkPlaceIdList() = intent {
        val bookmarkPlaceIdList = findPlaceIdListUseCase().getOrThrow()
        reduce { state.copy(bookmarkPlaceIdList = bookmarkPlaceIdList) }
    }

    fun onBookmarkClick(locationUIModel: LocationUIModel) = intent {
        val placeId = locationUIModel.placeId
        val isBookmarked = state.bookmarkPlaceIdList.contains(placeId)

        if (isBookmarked) {
            deletePlaceUseCase(placeId)
            reduce { state.copy(bookmarkPlaceIdList = state.bookmarkPlaceIdList - placeId) }
        } else {
            val location = locationUIModel.toDomainModel()
            insertPlaceUseCase(location)
            reduce { state.copy(bookmarkPlaceIdList = state.bookmarkPlaceIdList + placeId) }
        }
    }

    fun onResetClick() = intent {
        reduce { state.copy(keyword = "", locationUIModelFlow = emptyFlow()) }
    }

    companion object {
        val TAG = MainViewModel::class.simpleName
    }
}

@Immutable
data class MainScreenState(
    val keyword: String = "",
    val locationUIModelFlow: Flow<PagingData<LocationUIModel>> = emptyFlow(),
    val bookmarkPlaceIdList: List<String> = emptyList()
)

sealed interface MainScreenSideEffect {
    class Toast(val message: String) : MainScreenSideEffect
}