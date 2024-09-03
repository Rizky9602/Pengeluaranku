package com.muriz.pengeluaranku.ui.presentation.statistic.component

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import  androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DatePickerStatistic(
    visible: Boolean,
    currentMonth: Int,
    currentYear: Int,
    onDimiss: () -> Unit,
    modifier: Modifier = Modifier
) {

    val months =
        listOf("Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agt", "Sep", "Okt", "Nov", "Des")

    var month by remember { mutableStateOf(months[currentMonth]) }
    var year by remember { mutableStateOf(currentYear) }
    val interactionSource = remember { MutableInteractionSource() }

    if (visible) {
        Dialog(
            onDismissRequest = onDimiss,
        ) {
            Box(
                modifier = modifier.background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
            ) {
                Column {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
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
                                    }
                                )
                        )
                    }

                    Card(modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)) {
                        FlowRow(modifier = modifier.fillMaxWidth()) {

                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Test() {
    var showDialog by remember { mutableStateOf(true) }
    DatePickerStatistic(
        visible = showDialog,
        currentMonth = 9,
        currentYear = 2024,
        onDimiss = { showDialog = false })
}