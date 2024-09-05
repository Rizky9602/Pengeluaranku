package com.muriz.pengeluaranku.ui.presentation.statistic

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aay.compose.donutChart.model.PieChartData
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryOutcome
import com.muriz.pengeluaranku.ui.presentation.statistic.component.CategoryStatistic
import com.muriz.pengeluaranku.ui.presentation.statistic.component.DatePickerStatistic
import com.muriz.pengeluaranku.ui.presentation.statistic.component.PieChartStatistic
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun StatisticScreen(
    modifier: Modifier = Modifier, pieChartData: List<PieChartData>
) {

    val formated = Locale("in", "ID")
    val date = LocalDate.now()
    val month = date.format(DateTimeFormatter.ofPattern("MMMM", formated))

    var dateLabel by remember { mutableStateOf("$month ${date.year}") }
    var visible by remember { mutableStateOf(false) }

    Column(
        Modifier.background(colorResource(R.color.deepBlue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Statistik Pengeluaran Bulan $month",
            fontFamily = poppinsFontFamily,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 20.dp, bottom = 20.dp)
        )
        PieChartStatistic(
            modifier = modifier.size(300.dp),
            pieChartData = pieChartData
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.lightBlue)),
            contentAlignment = Alignment.TopCenter
        ) {
            Column {
                Spacer(modifier.height(50.dp))
                OutlinedTextField(
                    value = dateLabel,
                    onValueChange = { dateLabel = it },
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.CalendarMonth,
                            contentDescription = "Select date",
                            Modifier.clickable { visible = !visible }
                        )
                    },
                    textStyle = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = poppinsFontFamily,
                        color = Color.LightGray
                    ),
                    modifier = modifier
                        .width(200.dp)
                        .height(60.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.LightGray,
                        unfocusedBorderColor = Color.LightGray,
                        disabledBorderColor = Color.LightGray,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    singleLine = true
                )
                DatePickerStatistic(
                    visible = visible,
                    currentMonth = date.monthValue,
                    currentYear = date.year,
                    onDismiss = { visible = false },
                    selected = { monthChange, year ->
                        dateLabel = "${date.withMonth(monthChange).format(DateTimeFormatter.ofPattern("MMMM", formated))} $year"
                    }
                )
            }
        }
    }
}


@Preview
@Composable
private fun StatisticScreenPrev() {
    val pieChartData: List<PieChartData> = listOf(
        PieChartData(
            partName = CategoryOutcome.MAKANAN.names,
            color = colorResource(id = CategoryOutcome.MAKANAN.color),
            data = 2.0
        ),
        PieChartData(
            partName = CategoryOutcome.CEMILAN.names,
            color = colorResource(id = CategoryOutcome.CEMILAN.color),
            data = 2.0
        )
    )
    StatisticScreen(
        modifier = Modifier,
        pieChartData = pieChartData
    )
}