package com.harbourspace.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.harbourspace.myapplication.ui.data.UnsplashItem
import com.harbourspace.myapplication.ui.theme.colorContent20Transparency
import com.harbourspace.myapplication.ui.theme.colorContent85Transparency

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainContent(
    unsplashViewModel: UnsplashViewModel,
    openDetailsActivity: (UnsplashItem)->Unit
) {
    val items = unsplashViewModel.items.observeAsState()

    val loading = unsplashViewModel.loading.observeAsState(false)
    val pullRefreshState = rememberPullRefreshState(
        refreshing = loading.value,
        onRefresh = { unsplashViewModel.fetchImages() }
    )

    Box(
        Modifier.pullRefresh(pullRefreshState)
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                val search = remember { mutableStateOf("") }

                OutlinedTextField(
                    value = search.value,
                    onValueChange = { value ->
                        search.value = value
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.main_search_hint),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                    },
                    leadingIcon = {
                        val image = painterResource(id = R.drawable.ic_search)
                        val description = stringResource(R.string.description_search)

                        Image(
                            painter = image,
                            modifier = Modifier.size(25.dp),
                            contentDescription = description
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions {
                        unsplashViewModel.searchImages(search.value)
                    }
                )
            }

            item {
                if (items.value.isNullOrEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {

                        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
                        LottieAnimation(
                            composition,
                            iterations = LottieConstants.IterateForever,
                            modifier = Modifier.size(250.dp)
                        )
                    }
                }
            }

            items(items.value ?: emptyList()) { image ->
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { openDetailsActivity(image) }
                ) {

                    val painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image.urls?.regular)
                            .build()
                    )

                    Image(
                        painter = painter,
                        contentDescription = stringResource(id = R.string.description_image_preview),
                        contentScale = ContentScale.Crop
                    )

                    when (painter.state) {
                        is AsyncImagePainter.State.Success -> {
                            val verticalGradientBrush = Brush.verticalGradient(
                                colors = listOf(
                                    colorContent20Transparency,
                                    colorContent85Transparency
                                )
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(brush = verticalGradientBrush)
                            ) {}
                        }

                        is AsyncImagePainter.State.Loading -> {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.DarkGray),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_download),
                                    contentDescription = stringResource(id = R.string.description_image_preview),
                                    colorFilter = ColorFilter.tint(Color.Blue)
                                )
                            }
                        }

                        else -> {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.DarkGray),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_error),
                                    contentDescription = stringResource(id = R.string.description_image_preview),
                                    colorFilter = ColorFilter.tint(Color.Red)
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        image.user?.let { Text(it.name) }

                        Spacer(modifier = Modifier.height(8.dp))

                        image.description?.let { description ->
                            Text(
                                text = description,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }

        PullRefreshIndicator(loading.value, pullRefreshState, Modifier.align(Alignment.TopCenter))
    }
}