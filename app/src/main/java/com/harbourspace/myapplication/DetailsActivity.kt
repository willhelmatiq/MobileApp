package com.harbourspace.myapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                    Surface {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp),
                            painter = painterResource(id = R.drawable.bcn_la_sagrada_familia),
                            contentScale = ContentScale.Crop,
                            contentDescription = stringResource(id = R.string.description_image_preview)
                        )
                        Column(
                            modifier = Modifier.height(250.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
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

                }

                item {
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                contentScale = ContentScale.Crop,
                                painter = painterResource(id = R.drawable.guy_disturbed),
                                contentDescription = stringResource(R.string.avatar_description),
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = stringResource(id = R.string.avatar_description),
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                        }
                        Row(
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.ic_download),
                                contentDescription = stringResource(id = R.string.download_description),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = R.drawable.ic_favorite),
                                contentDescription = stringResource(id = R.string.favorite_description),
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Icon(
                                modifier = Modifier.size(30.dp),
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
                    Column() {
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
                        Row(modifier = Modifier.padding(all = 12.dp)) {
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.DarkGray
                                )
                            ) {
                                Text(
                                    modifier = Modifier.padding(all = 4.dp),
                                    text = "Barcelona",
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.DarkGray
                                )
                            ) {
                                Text(
                                    modifier = Modifier.padding(all = 4.dp),
                                    text = "Spain",
                                )
                            }
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