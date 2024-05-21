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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pagingwithcompose.ui.theme.PagingWithComposeTheme
import com.example.presentation.model.LocationUIModel

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
                    shape = RoundedCornerShape(8.dp)
                ).padding(vertical = 8.dp).padding(end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val isBookmarkPlace = bookmarkPlaceIdList.contains(locationUIModel.placeId)
            IconButton(onClick = { onBookmarkClick(locationUIModel) }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "북마크",
                    tint = if (isBookmarkPlace) {
                        Color.Red
                    } else {
                        Color.LightGray
                    }
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = locationUIModel.placeName,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = locationUIModel.addressName,
                    overflow = TextOverflow.Ellipsis
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