package com.example.presentation.searchlocation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.model.LocationUIModel
import com.example.presentation.theme.Dimensions
import com.example.presentation.theme.PagingWithComposeTheme
import com.example.presentation.theme.customColorScheme

const val BOOKMARK_TEXT = "북마크"

@Composable
fun LocationCard(
    locationUIModel: LocationUIModel,
    bookmarkPlaceIdList: List<String>,
    onBookmarkClick: (LocationUIModel) -> Unit,
) {
    Surface {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(Dimensions.xmedium)
                ).padding(
                    top = Dimensions.xmedium,
                    bottom = Dimensions.xmedium,
                    end = Dimensions.xmedium,
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val isBookmarkPlace = bookmarkPlaceIdList.contains(locationUIModel.placeId)
            IconButton(onClick = { onBookmarkClick(locationUIModel) }) {
                Icon(
                    modifier = Modifier.size(Dimensions.extra),
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = BOOKMARK_TEXT,
                    tint = if (isBookmarkPlace) {
                        MaterialTheme.customColorScheme.checkedIconColor
                    } else {
                        MaterialTheme.customColorScheme.uncheckedIconColor
                    }
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = locationUIModel.placeName,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.customColorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(Dimensions.small))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = locationUIModel.addressName,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.customColorScheme.onSurface.copy(
                        alpha = 0.8f
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun LocationCardPreview() {
    PagingWithComposeTheme {
        LocationCard(
            locationUIModel = LocationUIModel(
                placeId = "recteque",
                addressName = "Lila Robbins",
                placeName = "Elvin Battle",
            ),
            bookmarkPlaceIdList = emptyList(),
            onBookmarkClick = {}
        )
    }
}