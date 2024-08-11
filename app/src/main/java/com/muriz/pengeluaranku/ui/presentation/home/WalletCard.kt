package com.muriz.pengeluaranku.ui.presentation.home

import android.icu.text.DecimalFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.Pie

@Composable
fun WalletCard(
    saldo: Int,
    income: Int,
    outcome: Int,
    modifier: Modifier = Modifier
) {
    val decimalFormat = DecimalFormat("#,###")
    val statistic : Float
    val colorStatistic : Color
    if (income>=outcome){
        statistic = ((income - outcome) / income.toFloat()) * 100
        colorStatistic = colorResource(id = R.color.green)
    }else {
        statistic = ((outcome - income) / income.toFloat()) * 100
        colorStatistic = colorResource(id = R.color.red)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        colorResource(id = R.color.whiteBlue),
                        colorResource(id = R.color.darkWhiteBlue)
                    ),
                    endX = 620f
                ),
                shape = RoundedCornerShape(20.dp),
            )
            .fillMaxWidth()
            .height(121.dp)
    )
    {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = modifier
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .width(176.dp)
                    .height(81.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Saldoku : ",
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFontFamily,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Rp ${decimalFormat.format(saldo)}",
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFontFamily,
                        fontSize = 25.sp
                    )
                }
            }
            Spacer(modifier = Modifier.size(60.dp))
            Box(modifier = modifier) {
                PieChart(
                    modifier = modifier.size(100.dp),
                    data = listOf(
                        Pie(
                            label = "income",
                            data = income.toDouble()  - outcome,
                            color = colorResource(id = R.color.green)
                        ),
                        Pie(
                            label = "outcome",
                            data = outcome.toDouble() ,
                            color = colorResource(id = R.color.red)
                        )
                    ),
                    spaceDegree = 0f,
                    style = Pie.Style.Stroke(width = 15.dp)
                )
                Text(
                    text = "${statistic.toInt()} %",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    color = colorStatistic,
                    modifier = modifier.align(Alignment.Center)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Test() {
    WalletCard(saldo = 5100000,  income = 1000, outcome = 1200)
}