package com.example.presentation

import androidx.paging.PagingData
import com.example.domain.model.Location
import com.example.domain.usecase.main.SearchKeywordUseCase
import com.example.domain.usecase.room.DeletePlaceUseCase
import com.example.domain.usecase.room.FindPlaceIdListUseCase
import com.example.domain.usecase.room.InsertPlaceUseCase
import com.example.presentation.searchlocation.SearchLocationViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import org.junit.Assert
import org.junit.Before
import org.junit.Test

private const val testKeyword = "부천"

class SearchLocationViewModelTest {
    private lateinit var searchKeywordUseCase: SearchKeywordUseCase
    private lateinit var insertPlaceUseCase: InsertPlaceUseCase
    private lateinit var findPlaceIdListUseCase: FindPlaceIdListUseCase
    private lateinit var deletePlaceUseCase: DeletePlaceUseCase

    private lateinit var viewModel: SearchLocationViewModel

    @Before
    fun setUp() {
        searchKeywordUseCase = FakeSearchKeywordUseCase()
        insertPlaceUseCase = FakeInsertPlaceUseCase()
        findPlaceIdListUseCase = FakeFindPlaceIdListUseCase()
        deletePlaceUseCase = FakeDeletePlaceUseCase()

        viewModel = SearchLocationViewModel(
            searchKeywordUseCase = searchKeywordUseCase,
            insertPlaceUseCase = insertPlaceUseCase,
            findPlaceIdListUseCase = findPlaceIdListUseCase,
            deletePlaceUseCase = deletePlaceUseCase
        )
    }

    @Test
    fun onTextChangeTest() {
        Assert.assertEquals(viewModel.container.stateFlow.value.keyword, "")

        viewModel.onTextChange(testKeyword)

        Assert.assertEquals(viewModel.container.stateFlow.value.keyword, testKeyword)
    }

    class FakeSearchKeywordUseCase : SearchKeywordUseCase {
        override suspend fun invoke(
            query: String
        ): Result<Flow<PagingData<Location>>> = runCatching {
            emptyFlow()
        }
    }

    class FakeInsertPlaceUseCase : InsertPlaceUseCase {
        override suspend fun invoke(location: Location): Result<Unit> = runCatching {

        }
    }

    class FakeFindPlaceIdListUseCase : FindPlaceIdListUseCase {
        override suspend fun invoke(): Result<List<String>> = runCatching {
            emptyList()
        }
    }

    class FakeDeletePlaceUseCase : DeletePlaceUseCase {
        override suspend fun invoke(placeId: String): Result<Unit> = runCatching {

        }
    }
}