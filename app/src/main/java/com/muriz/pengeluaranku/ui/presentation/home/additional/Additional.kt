package com.muriz.pengeluaranku.ui.presentation.home.additional

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily
import org.w3c.dom.Text

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Additional(modifier: Modifier = Modifier) {

    val additionalContent = listOf(
        TabItem(
            content = { OutcomeScreen() },
            unSelectedText = {
                Text(
                    text = "Outcome",
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.5f)
                )
            },
            selectedText = {
                Text(
                    text = "Outcome",
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        ),
        TabItem(
            content = { IncomeScreen() },
            unSelectedText = {
                Text(
                    text = "Income",
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.5f)
                )
            },
            selectedText = {
                Text(
                    text = "Income",
                    fontFamily = poppinsFontFamily,
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        )
    )

    @Composable
    fun tabContent(index: Int, modifier: Modifier = Modifier) {
        additionalContent.getOrNull(index)?.content?.invoke()
    }

    var selectedIndexItem by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.deepBlue))
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = colorResource(id = R.color.deepBlue))
        ) {}
        TabRow(
            selectedTabIndex = selectedIndexItem,
            modifier = modifier
                .padding(start = 10.dp, end = 10.dp)
        ) {
            additionalContent.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedIndexItem,
                    onClick = { selectedIndexItem = index },
                    text =
                    if (index == selectedIndexItem) {
                        tabItem.selectedText
                    } else {
                        tabItem.unSelectedText
                    },
                    unselectedContentColor = colorResource(id = R.color.deepBlue),
                    selectedContentColor = colorResource(id = R.color.lightBlue),
                    modifier = modifier
                        .height(40.dp)
                        .border(
                            BorderStroke(
                                width = 1.dp, color = colorResource(
                                    id = R.color.lightBlue
                                )
                            ),
                            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                        )
                        .background(Color.Black)
                )
            }
        }
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.lightBlue)),
            contentAlignment = Alignment.TopCenter
        ) {
            tabContent(index = selectedIndexItem)
        }
    }
}

data class TabItem(
    val content: @Composable () -> Unit,
    val unSelectedText: @Composable () -> Unit,
    val selectedText: @Composable () -> Unit,
)

@Preview
@Composable
private fun TestAdditional() {
    Additional()
}