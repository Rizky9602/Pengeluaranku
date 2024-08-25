package com.muriz.pengeluaranku.ui.presentation.home.additional

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun Additional(navHostController: NavHostController, modifier: Modifier = Modifier) {
    val additionalContent = listOf(
        TabItem(
            content = { OutcomeScreen() },
            unSelectedText = TextStyle(
                color = Color.White.copy(alpha = 0.5f),
                fontFamily = poppinsFontFamily
            ),
            unSelectBox = modifier
                .background(
                    color = colorResource(id = R.color.deepBlue),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
                .border(
                    border = BorderStroke(
                        color = colorResource(id = R.color.lightBlue).copy(
                            alpha = 0.7f
                        ), width = 1.dp
                    )
                ),
            selectedText = TextStyle(
                color = Color.White.copy(alpha = 0.5f),
                fontFamily = poppinsFontFamily
            ),
            SelectedBox = modifier
                .background(
                    color = colorResource(id = R.color.lightBlue),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
                .border(
                    border = BorderStroke(
                        color = colorResource(id = R.color.lightBlue), width = 1.dp
                    )
                )
        ),
        TabItem(
            content = { IncomeScreen() },
            unSelectedText = TextStyle(
                color = Color.White.copy(alpha = 0.5f),
                fontFamily = poppinsFontFamily
            ),
            unSelectBox = modifier
                .background(
                    color = colorResource(id = R.color.deepBlue),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
                .border(
                    border = BorderStroke(
                        color = colorResource(id = R.color.lightBlue).copy(
                            alpha = 0.7f
                        ), width = 1.dp
                    )
                ),
            selectedText = TextStyle(
                color = Color.White.copy(alpha = 0.5f),
                fontFamily = poppinsFontFamily
            ),
            SelectedBox = modifier
                .background(
                    color = colorResource(id = R.color.lightBlue),
                    shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                )
                .border(
                    border = BorderStroke(
                        color = colorResource(id = R.color.lightBlue), width = 1.dp
                    )
                )
        )

    )
}

@Composable
fun AdditionalComponent(modifier: Modifier = Modifier) {

}


data class TabItem(
    val content: @Composable () -> Unit,
    val unSelectedText: TextStyle,
    val unSelectBox: Modifier,
    val selectedText: TextStyle,
    val SelectedBox: Modifier
)