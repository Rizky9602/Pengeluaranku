package com.muriz.pengeluaranku.ui.presentation.home

import android.icu.text.DecimalFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily
import java.time.LocalDate

@Composable
fun OutcomeHistory(
    modifier: Modifier = Modifier,
    icon: Int,
    name: String,
    date: LocalDate,
    quantity: Int
) {
    val decimalFormat = DecimalFormat("#,###")
    Box(
        modifier = modifier
            .background(
                color = colorResource(id = R.color.deepBlue),
                shape = RoundedCornerShape(50.dp)
            )
            .fillMaxWidth()
            .height(80.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(modifier.padding(15.dp)) {
            Box(
                modifier = modifier
                    .background(color = Color.White, shape = CircleShape)
                    .size(48.dp), contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = "outcome's icon",
                    modifier.size(32.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center, modifier = modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp)
            ) {
                Text(text = name, fontFamily = poppinsFontFamily, color = Color.White)
                Text(text = date.toString(), fontFamily = poppinsFontFamily, color = Color.White)
            }
            Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                Box(
                    modifier = modifier
                        .size(width = 89.dp, height = 44.dp)
                        .border(
                            BorderStroke(
                                width = 1.dp, color = colorResource(
                                    id = R.color.lightPurple
                                )
                            ), shape = RoundedCornerShape(20.dp)
                        ), contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "-${decimalFormat.format(quantity)}",
                        color = Color.White,
                        fontFamily = poppinsFontFamily
                    )
                }
            }
        }
    }
}