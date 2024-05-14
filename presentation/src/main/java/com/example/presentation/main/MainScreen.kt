package com.example.presentation.main

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.pagingwithcompose.ui.theme.PagingWithComposeTheme
import com.example.presentation.component.PWCTextField
import com.example.presentation.model.LocationUIModel
import kotlinx.coroutines.flow.flowOf
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

const val EMPTY_KEYWORD_TEXT = "키워드를 입력해주세요."
const val EMPTY_LOCATION_TEXT = "검색 결과가 없습니다."

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val state: MainScreenState = viewModel.collectAsState().value
    viewModel.collectSideEffect { sideEffect ->
        when (sideEffect) {
            is MainScreenSideEffect.Toast ->
                Toast.makeText(context, sideEffect.message, Toast.LENGTH_SHORT).show()
        }
    }

    MainScreen(
        keyword = state.keyword,
        locationUIModelList = state.locationUIModelFlow.collectAsLazyPagingItems(),
        onTextChange = viewModel::onTextChange,
        onResetClick = viewModel::onResetClick,
        onBookmarkClick = viewModel::onBookmarkClick
    )
}

@Composable
private fun MainScreen(
    keyword: String,
    locationUIModelList: LazyPagingItems<LocationUIModel>,
    onTextChange: (String) -> Unit,
    onResetClick: () -> Unit,
    onBookmarkClick: (Boolean) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            Box {
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

                IconButton(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    onClick = onResetClick,
                ) {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = "지우기",
                        tint = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (locationUIModelList.itemCount == 0) {
                val text = if (keyword.isBlank()) EMPTY_KEYWORD_TEXT else EMPTY_LOCATION_TEXT
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = text,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(
                        count = locationUIModelList.itemCount,
                        key = { index -> locationUIModelList[index]?.id ?: index }
                    ) { index ->
                        locationUIModelList[index]?.run {
                            LocationCard(
                                id = this.id,
                                placeName = this.placeName,
                                addressName = this.addressName,
                                isBookmark = true,
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
fun MainScreenPreview() {
    val defaultFlow = flowOf(
        PagingData.from(
            listOf(
                LocationUIModel(
                    id = "id",
                    addressName = "Blanche Davis",
                    placeName = "Mariano Gentry"
                ),
            )
        )
    )

    PagingWithComposeTheme {
        MainScreen(
            keyword = "asdasd",
            locationUIModelList = defaultFlow.collectAsLazyPagingItems(),
            onTextChange = {},
            onResetClick = {},
            onBookmarkClick = {}
        )
    }
}