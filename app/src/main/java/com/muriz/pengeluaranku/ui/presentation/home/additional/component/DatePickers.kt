package com.muriz.pengeluaranku.ui.presentation.home.additional.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Popup
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.compose.material3.DatePicker
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickers(modifier: Modifier = Modifier) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    var selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: "Pilih Tanggal"

    var selectColor = if (datePickerState.selectedDateMillis != null) {
        Color.Black
    } else {
        Color.LightGray
    }

    LaunchedEffect(datePickerState.selectedDateMillis) {
        if (datePickerState.selectedDateMillis != null) {
            showDatePicker = false
        }
    }


    Column(modifier.padding(top = 10.dp)) {
        Text(
            text = "Tanggal",
            fontFamily = poppinsFontFamily,
            fontSize = 20.sp,
            color = Color.White
        )
        OutlinedTextField(
            value = selectedDate,
            onValueChange = { selectedDate = it },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Select date"
                    )
                }
            },
            textStyle = TextStyle(
                fontSize = 16.sp,
                fontFamily = poppinsFontFamily,
                color = selectColor
            ),
            modifier = modifier
                .fillMaxWidth()
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
        if (showDatePicker) {
            Popup(onDismissRequest = { showDatePicker = false }, alignment = Alignment.Center) {
                Box(
                    modifier = modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()

                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false,
                        modifier = modifier.background(
                            Color.White,
                            shape = RoundedCornerShape(15.dp)
                        ).border(
                            border = BorderStroke(5.dp, Color.Black),
                            shape = RoundedCornerShape(15.dp)
                        )
                    )
                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale("in", "ID"))
    return formatter.format(Date(millis))
}