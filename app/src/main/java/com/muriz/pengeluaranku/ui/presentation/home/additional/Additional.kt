package com.muriz.pengeluaranku.ui.presentation.home.additional

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController

@Composable
fun Additional(navHostController: NavHostController,modifier: Modifier = Modifier) {
    
}

@Composable
fun AdditionalComponent(modifier: Modifier = Modifier) {
    
}

data class TabItem(
    val content:@Composable () -> Unit,
    val unSelected : TextStyle,
    val selected : TextStyle
)