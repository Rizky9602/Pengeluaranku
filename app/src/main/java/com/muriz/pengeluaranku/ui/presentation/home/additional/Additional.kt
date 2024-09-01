package com.muriz.pengeluaranku.ui.presentation.home.additional


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun Additional(modifier: Modifier = Modifier,navController: NavController) {

    val selectedScreenName = listOf(
        ScreenAdditional(
            name = "Outcome",
            screen = { OutcomeScreen(navController = navController) }
        ),
        ScreenAdditional(
            name = "Income",
            screen = { IncomeScreen(navController = navController) }
        )
    )
    var selectedScreen by remember { mutableStateOf("Outcome") }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
        .fillMaxSize()
        .background(
            color = colorResource(
                id = R.color.deepBlue
            )
        )) {
        Spacer(modifier = modifier.height(50.dp))
        LazyRow {
            items(selectedScreenName) { item ->
                AdditionalView(
                    name = item.name,
                    selectedScreen = selectedScreen,
                    onClickSelected = { selectedScreen = item.name })
            }
        }
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.lightBlue))
            .padding(top = 40.dp)
        )
        {
            if(selectedScreen == "Outcome"){
                OutcomeScreen(navController = navController )
            }else{
                IncomeScreen(navController = navController)
            }
        }
    }
}

@Composable
fun AdditionalView(
    name: String,
    selectedScreen: String,
    onClickSelected:  (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val colorContainer = if (name == selectedScreen) colorResource(id = R.color.lightBlue) else colorResource(
        id = R.color.deepBlue)
    val colorText = if (name == selectedScreen) Color.White else Color.White.copy(0.5f)

    Card(
        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        colors = CardColors(
            containerColor = colorContainer,
            disabledContainerColor = colorContainer,
            contentColor = colorText,
            disabledContentColor = colorText,
        ),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.lightBlue)),
        modifier = modifier
            .size(width = 180.dp, height = 45.dp)
            .background(color = colorResource(id = R.color.deepBlue))
            .padding(end = 5.dp),
        onClick = {onClickSelected(name)}
    ) {
        Box (
            modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = name,
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp
            )
        }
    }
}

data class ScreenAdditional(
    val name: String,
    val screen: @Composable () -> Unit
)