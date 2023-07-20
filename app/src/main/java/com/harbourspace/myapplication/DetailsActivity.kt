package com.harbourspace.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val TAG = "DetailsActivity"

class DetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            LazyColumn {
                item {
                    Surface{
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            painter = painterResource(id = R.drawable.bcn_la_sagrada_familia),
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(id = R.string.description_image_preview)
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                painter = painterResource(id = R.drawable.ic_pin_drop),
                                contentDescription = "",
                                tint = Color.White
                            )
                            Text(
                                text = stringResource(id = R.string.map_location),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )
                        }

                    }

                }

                item {
                    Row(
                        modifier = Modifier.padding(16.dp)
                            .fillMaxWidth(),

                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                                .fillMaxWidth(),
                        ) {

                        }
                        Column(
                            modifier = Modifier.padding(16.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.End
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
//                                .padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_download),
                                contentDescription = stringResource(id = R.string.download_description),
                                tint = Color.White
                            )
                            Icon(
                                modifier = Modifier.size(30.dp),
//                                .padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_favorite),
                                contentDescription = stringResource(id = R.string.favorite_description),
                                tint = Color.White
                            )
                            Icon(
                                modifier = Modifier.size(30.dp),
//                                .padding(16.dp),
                                painter = painterResource(id = R.drawable.ic_bookmark),
                                contentDescription = stringResource(id = R.string.bookmark_description),
                                tint = Color.White
                            )
                        }

                    }
                }

                item {
                    Row(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1.0f)
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_camera_title),
                                subtitle = stringResource(id = R.string.details_camera_default)
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1.0f)
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_aperture_title),
                                subtitle = stringResource(id = R.string.details_aperture_default)
                            )
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1.0f)
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_focal_title),
                                subtitle = stringResource(id = R.string.details_focal_default)
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1.0f)
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_shutter_title),
                                subtitle = stringResource(id = R.string.details_shutter_default)
                            )
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1.0f)
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_iso_title),
                                subtitle = stringResource(id = R.string.details_iso_default)
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1.0f)
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_dimensions_title),
                                subtitle = stringResource(id = R.string.details_dimensions_default)
                            )
                        }
                    }
                }

                item {
                    Divider(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                        thickness = 1.dp,
                        color = Color.LightGray
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_views_title),
                                subtitle = stringResource(id = R.string.details_views_default)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_downloads_title),
                                subtitle = stringResource(id = R.string.details_downloads_default)
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AddImageInformation(
                                title = stringResource(id = R.string.details_likes_title),
                                subtitle = stringResource(id = R.string.details_likes_default)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddImageInformation(
    title: String,
    subtitle: String
) {

    Text(
        text = title,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )

    Text(
        text = subtitle,
        fontSize = 15.sp,
        color = Color.White
    )
}