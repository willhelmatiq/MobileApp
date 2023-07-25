package com.harbourspace.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.harbourspace.myapplication.ui.data.UnsplashItem

@Composable
fun MainScreen(
    unsplashViewModel: UnsplashViewModel,
    openDetailsActivity: (UnsplashItem) -> Unit
) {
    val selected = remember { mutableStateOf(0) }

    Column {

        val actions = listOf(Tab.HOME, Tab.COLLECTIONS)
        TabRow(
            selectedTabIndex = selected.value,
            divider = {}
        ) {
            actions.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier.height(48.dp),
                    selected = selected.value == index,
                    onClick = { selected.value = index }
                ) {
                    Text(
                        text = stringResource(id = Tab.values()[index].tab)
                    )
                }
            }
        }

        when(selected.value) {
            Tab.HOME.ordinal -> {
                MainContent(
                    unsplashViewModel = unsplashViewModel,
                    openDetailsActivity = { item -> openDetailsActivity(item) }
                )
            }

            Tab.COLLECTIONS.ordinal -> {
                CollectionsContent(
                    unsplashViewModel = unsplashViewModel
                )
            }
        }
    }
}