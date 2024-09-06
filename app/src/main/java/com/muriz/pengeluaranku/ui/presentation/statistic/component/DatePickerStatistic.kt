package com.muriz.pengeluaranku.ui.presentation.statistic.component

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CalendarMonth
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DatePickerStatistic(
    visible: Boolean,
    currentMonth: Int,
    currentYear: Int,
    onDismiss: () -> Unit,
    selected: (Int, Int) -> Unit,
    modifier: Modifier = Modifier
) {

    val months =
        listOf("Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agt", "Sep", "Okt", "Nov", "Des")

    var month by remember { mutableStateOf(months[currentMonth - 1]) }
    var year by remember { mutableIntStateOf(currentYear) }
    val interactionSource = remember { MutableInteractionSource() }

    var temp : Int

    if (visible) {
        Dialog(
            onDismissRequest = onDismiss,
        ) {
            Box(
                modifier = modifier.background(
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                ).padding(5.dp).height(350.dp),
            ) {
                Column(modifier = modifier.padding(top = 20.dp)) {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = modifier
                                .size(35.dp)
                                .rotate(90f)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null,
                                    onClick = {
                                        year--
                                    })
                        )
                        Text(
                            text = year.toString(),
                            fontFamily = poppinsFontFamily,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = modifier.padding(horizontal = 20.dp)
                        )
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = modifier
                                .size(35.dp)
                                .rotate(-90f)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null,
                                    onClick = {
                                        year++
                                        selected( currentMonth,year)
                                    }
                                )
                        )
                    }

                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                            .background(color = Color.Transparent),
                        elevation = 0.dp
                    ) {
                        FlowRow(
                            modifier = modifier.fillMaxWidth(),
                            maxItemsInEachRow = 3,
                            horizontalArrangement = Arrangement.SpaceAround,
                        ) {
                            months.forEach {
                                Box(
                                    modifier = modifier
                                        .size(60.dp)
                                        .clickable(
                                            indication = null,
                                            interactionSource = interactionSource,
                                            onClick = {
                                                month = it
                                                selected(months.indexOf(it) + 1, year)
                                            }
                                        )
                                        .background(Color.Transparent),
                                    contentAlignment = Alignment.Center
                                ) {
                                    val animatedSize by animateDpAsState(
                                        targetValue = if (it == month) 60.dp else 0.dp,
                                        animationSpec = tween(
                                            durationMillis = 500,
                                            easing = LinearOutSlowInEasing
                                        ), label = "selected animation"
                                    )

                                    Box(
                                        modifier = modifier
                                            .size(animatedSize)
                                            .background(
                                                color = if (it == month) colorResource(id = R.color.lightBlue) else Color.Transparent,
                                                shape = CircleShape
                                            )
                                    )

                                    Text(
                                        text = it,
                                        fontFamily = poppinsFontFamily,
                                        color = if (it == month) Color.White else Color.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}