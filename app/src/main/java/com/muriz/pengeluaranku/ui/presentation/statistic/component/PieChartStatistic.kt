package com.muriz.pengeluaranku.ui.presentation.statistic.component

import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.aay.compose.baseComponents.model.LegendPosition
import com.aay.compose.donutChart.PieChart
import com.aay.compose.donutChart.model.PieChartData
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryOutcome
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun PieChartStatistic(
    modifier: Modifier,
    pieChartData : List<PieChartData>

) {
    PieChart(
        pieChartData = pieChartData,
        ratioLineColor = Color.White,
        textRatioStyle = TextStyle(color = Color.White, fontFamily = poppinsFontFamily, fontSize = 9.sp, background = Color.Transparent),
        legendPosition = LegendPosition.DISAPPEAR,
        outerCircularColor = colorResource(id = R.color.deepBlue),
        animation = tween(1500),
        modifier = modifier,
    )
}
