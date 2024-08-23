package com.muriz.pengeluaranku.ui.presentation.home.additional.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun ConfirmationButton(modifier: Modifier = Modifier) {

    val simpanColor = colorResource(id = R.color.green)
    val batalColor = colorResource(id = R.color.red)

    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()) {
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonColors(
                contentColor = Color.White,
                disabledContentColor = Color.White,
                containerColor = batalColor,
                disabledContainerColor = batalColor
            ),
            modifier = modifier.size(width = 111.dp,36.dp)
        ) {
            Text(text = "Batal", fontFamily = poppinsFontFamily)
        }

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = simpanColor,
                disabledContainerColor = simpanColor,
                disabledContentColor = Color.White
            ),
            modifier = modifier.size(width = 111.dp,36.dp),
        ) {
            Text(text = "Simpan", fontFamily = poppinsFontFamily,)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Tests() {
    ConfirmationButton()
}