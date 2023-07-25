package com.harbourspace.unsplash.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.harbourspace.myapplication.R

sealed class BottomNavigationScreen(
    val route: String,
    @StringRes val stringResId: Int,
    @DrawableRes val drawResId: Int
) {
    object Home : BottomNavigationScreen("Home", R.string.main_navigation_home, R.drawable.ic_home)
    object About : BottomNavigationScreen("About", R.string.main_navigation_about, R.drawable.ic_info)
}
