package com.muriz.pengeluaranku.ui.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun Profile(name: String, desc: String, image: Int, modifier: Modifier = Modifier) {
    Row(
        Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                fontFamily = poppinsFontFamily,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = desc,
                fontFamily = poppinsFontFamily,
                color = Color(0xFFBDC0FF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                modifier = Modifier.width(250.dp)
            )
        }
        Image(
            painter = painterResource(id = image),
            contentDescription = "Photo Profile",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .clip(CircleShape)
                .size(80.dp)
        )
    }
}