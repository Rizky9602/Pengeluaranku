package com.muriz.pengeluaranku.ui.presentation.statistic.component

import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.aay.compose.baseComponents.model.LegendPosition
import com.aay.compose.donutChart.PieChart
import com.aay.compose.donutChart.model.PieChartData
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryOutcome
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun PieChartStatistic(
    dataMakanan: Double,
    dataCemilan: Double,
    dataKeluarga: Double,
    dataPakaian: Double,
    dataMinuman: Double,
    dataTabungan: Double,
    dataTranport: Double,
    dataBelanja: Double,
    modifier: Modifier

) {
    val pieChartData: List<PieChartData> = listOf(
        PieChartData(
            partName = CategoryOutcome.MAKANAN.names,
            color = colorResource(id = CategoryOutcome.MAKANAN.color),
            data = dataMakanan
        ),
        PieChartData(
            partName = CategoryOutcome.CEMILAN.names,
            color = colorResource(id = CategoryOutcome.CEMILAN.color),
            data = dataCemilan
        ),
        PieChartData(
            partName = CategoryOutcome.KELUARGA.names,
            color = colorResource(id = CategoryOutcome.KELUARGA.color),
            data = dataKeluarga
        ),
        PieChartData(
            partName = CategoryOutcome.PAKAIAN.names,
            color = colorResource(id = CategoryOutcome.PAKAIAN.color),
            data = dataPakaian
        ),
        PieChartData(
            partName = CategoryOutcome.MINUMAN.names,
            color = colorResource(id = CategoryOutcome.MINUMAN.color),
            data = dataMinuman
        ),
        PieChartData(
            partName = CategoryOutcome.TABUNGAN.names,
            color = colorResource(id = CategoryOutcome.TABUNGAN.color),
            data = dataTabungan
        ),
        PieChartData(
            partName = CategoryOutcome.TRANSPORTASI.names,
            color = colorResource(id = CategoryOutcome.TRANSPORTASI.color),
            data = dataTranport
        ),
        PieChartData(
            partName = CategoryOutcome.BELANJA_KEBUTUHAN.names,
            color = colorResource(id = CategoryOutcome.BELANJA_KEBUTUHAN.color),
            data = dataBelanja
        )
    )

    PieChart(
        pieChartData = pieChartData,
        ratioLineColor = Color.White,
        textRatioStyle = TextStyle(color = Color.White, fontFamily = poppinsFontFamily,),
        legendPosition = LegendPosition.DISAPPEAR,
        outerCircularColor = colorResource(id = R.color.deepBlue),
        animation = tween(1500),
        modifier = modifier
    )
}