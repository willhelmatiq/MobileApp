package com.harbourspace.myapplication

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.pager.HorizontalPagerIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollectionsContent(
    unsplashViewModel: UnsplashViewModel
) {
    val collections = unsplashViewModel.collections.observeAsState()
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {

            Column {
                val pagerState = rememberPagerState(pageCount = {
                    collections.value?.size ?: 0
                })

                HorizontalPager(
                    state = pagerState
                ) { page ->

                    val item = collections.value!![page]

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {

                        val painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.cover_photo.urls.regular)
                                .build()
                        )

                        Image(
                            painter = painter,
                            contentDescription = stringResource(id = R.string.description_image_preview),
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                if (pagerState.pageCount > 1) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            pageCount = collections.value?.size ?: 0,
                            activeColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    }
                }
            }
        }
    }
}