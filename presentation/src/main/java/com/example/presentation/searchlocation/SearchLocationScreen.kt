package com.example.presentation.searchlocation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.component.PWCTextField
import com.example.presentation.model.LocationUIModel
import com.example.presentation.theme.Dimensions
import com.example.presentation.theme.PagingWithComposeTheme
import kotlinx.coroutines.flow.flowOf
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

const val EMPTY_KEYWORD_TEXT = "키워드를 입력해주세요."
const val EMPTY_LOCATION_TEXT = "검색 결과가 없습니다."
const val DELETE_TEXT = "지우기"

@Composable
fun SearchLocationScreen(
    viewModel: SearchLocationViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val context = LocalContext.current

    val state: SearchLocationScreenState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is SearchLocationScreenSideEffect.Toast ->
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
        }
    }

    SearchLocationScreen(
        keyword = state.keyword,
        locationUIModelList = state.locationUIModelFlow.collectAsLazyPagingItems(),
        bookmarkPlaceIdList = state.bookmarkPlaceIdList,
        onTextChange = viewModel::onTextChange,
        onBackClick = onBackClick,
        onResetClick = viewModel::onResetClick,
        onBookmarkClick = viewModel::onBookmarkClick
    )
}

@Composable
private fun SearchLocationScreen(
    keyword: String,
    locationUIModelList: LazyPagingItems<LocationUIModel>,
    bookmarkPlaceIdList: List<String>,
    onTextChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onResetClick: () -> Unit,
    onBookmarkClick: (LocationUIModel) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = Dimensions.medium)
        ) {
            Row(
                modifier = Modifier.padding(end = Dimensions.xlarge, start = Dimensions.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        modifier = Modifier.size(Dimensions.extra),
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "뒤로 가기",
                        tint = Color.Black
                    )
                }

                Box(modifier = Modifier.padding(start = Dimensions.small)) {
                    PWCTextField(
                        modifier = Modifier.fillMaxWidth(),
                        text = keyword,
                        onTextChange = onTextChange,
                        visualTransformation = VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                        keyboardActions = KeyboardActions(
                            onSearch = { focusManager.clearFocus() }
                        )
                    )

                    if (keyword.isNotBlank()) {
                        IconButton(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            onClick = onResetClick,
                        ) {
                            Icon(
                                modifier = Modifier.size(Dimensions.xlarge),
                                imageVector = Icons.Rounded.Clear,
                                contentDescription = DELETE_TEXT,
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(Dimensions.medium))

            if (locationUIModelList.itemCount == 0) {
                val text = if (keyword.isBlank()) EMPTY_KEYWORD_TEXT else EMPTY_LOCATION_TEXT
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = text,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(horizontal = Dimensions.xlarge),
                    verticalArrangement = Arrangement.spacedBy(Dimensions.medium)
                ) {
                    items(
                        count = locationUIModelList.itemCount,
                        key = { index -> locationUIModelList[index]?.placeId ?: index }
                    ) { index ->
                        locationUIModelList[index]?.run {
                            LocationCard(
                                locationUIModel = this,
                                bookmarkPlaceIdList = bookmarkPlaceIdList,
                                onBookmarkClick = onBookmarkClick
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchLocationScreenPreview() {
    val defaultFlow = flowOf(
        PagingData.from(
            listOf(
                LocationUIModel(
                    placeId = "id",
                    addressName = "Blanche Davis",
                    placeName = "Mariano Gentry",
                ),
            )
        )
    )

    PagingWithComposeTheme {
        SearchLocationScreen(
            keyword = "asdasd",
            locationUIModelList = defaultFlow.collectAsLazyPagingItems(),
            bookmarkPlaceIdList = emptyList(),
            onTextChange = {},
            onBackClick = {},
            onResetClick = {},
            onBookmarkClick = {}
        )
    }
}