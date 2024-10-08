package com.muriz.pengeluaranku.ui.presentation.home.additional.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun InputBox(
    modifier: Modifier = Modifier,
    inputName: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    label: String = ""
) {
    var text by remember { mutableStateOf("") }

    Column(modifier.fillMaxWidth()) {
        Text(
            text = inputName,
            fontFamily = poppinsFontFamily,
            color = Color.White,
            fontSize = 20.sp,
            modifier = modifier
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            textStyle = TextStyle(
                fontFamily = poppinsFontFamily,
                fontSize = 16.sp,
                color = Color.Black
            ),
            placeholder = {
                Text(text = label,
                    fontSize = 16.sp,
                    fontFamily = poppinsFontFamily,
                    color = Color.LightGray,)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray,
                disabledBorderColor = Color.LightGray,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp),
            shape = RoundedCornerShape(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = keyboardType
            ),
            singleLine = true
        )

    }
}