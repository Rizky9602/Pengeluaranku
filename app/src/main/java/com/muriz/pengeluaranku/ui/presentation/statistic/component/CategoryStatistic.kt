package com.muriz.pengeluaranku.ui.presentation.statistic.component

import android.icu.text.DecimalFormat
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun CategoryStatistic(
    name: String,
    quantity: Int,
    color: Color,
    value: Double,
    modifier: Modifier = Modifier
) {

    val decimalFormat = DecimalFormat("#,###")
    var progress by remember { mutableFloatStateOf(0f) }
    val size by animateFloatAsState(
        targetValue = progress,
        tween(durationMillis = 1500, delayMillis = 200, easing = LinearOutSlowInEasing),
        label = "progress bar animation"
    )

    Box(modifier = modifier.fillMaxWidth()) {
        Divider(
            color = Color.White, modifier = modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(start = 30.dp, end = 30.dp)
        ) {

            Text(text = name, fontSize = 16.sp, fontFamily = poppinsFontFamily, color = Color.White)
            Text(
                text = "Rp ${decimalFormat.format(quantity).replace(",", ".")}",
                color = Color.White,
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp
            )
            Box(
                modifier = modifier
                    .height(17.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(9.dp))
                        .background(color = Color.White)
                )
                Box(
                    modifier = modifier
                        .fillMaxWidth(size)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(9.dp))
                        .background(color = color)
                        .animateContentSize()
                )
            }
        }
        Divider(
            color = Color.White, modifier = modifier
                .height(1.dp)
                .fillMaxWidth()
        )
    }
    LaunchedEffect(key1 = true) {
        progress = value.toFloat()
    }
}