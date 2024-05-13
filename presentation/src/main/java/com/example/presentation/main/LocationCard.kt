package com.example.presentation.main

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
import androidx.compose.material.icons.outlined.FavoriteBorder
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

@Composable
fun LocationCard(
    id: String,
    placeName: String,
    addressName: String,
    isBookmark: Boolean,
    onBookmarkClick: (Boolean) -> Unit
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
            IconButton(onClick = { onBookmarkClick(!isBookmark) }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = if (isBookmark) {
                        Icons.Filled.Favorite
                    } else {
                        Icons.Outlined.FavoriteBorder
                    },
                    contentDescription = "북마크",
                    tint = if (isBookmark) {
                        Color.Red
                    } else {
                        Color.Gray
                    }
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = placeName,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = addressName,
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
            id = "1",
            placeName = "강남역 2호선",
            addressName = "서울 강남구 강남대로 지하 396 지하",
            isBookmark = true,
            onBookmarkClick = {}
        )
    }
}