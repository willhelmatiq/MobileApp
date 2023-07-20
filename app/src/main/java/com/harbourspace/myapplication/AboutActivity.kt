package com.harbourspace.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harbourspace.myapplication.ui.theme.UnsplashTheme

class AboutActivity  : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnsplashTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black)
                        .padding(16.dp),
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = stringResource(id = R.string.about_text),
                            color = Color.White,
                            fontSize = 19.sp,
                            fontStyle = FontStyle.Normal
                        )

                        Spacer(modifier = Modifier.height(75.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ic_android),
                                contentDescription = stringResource(id = R.string.description_android),
                                modifier = Modifier.size(75.dp)
                            )

                            Image(
                                painter = painterResource(id = R.drawable.ic_kotlin),
                                contentDescription = stringResource(id = R.string.description_kotlin),
                                modifier = Modifier.size(75.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}