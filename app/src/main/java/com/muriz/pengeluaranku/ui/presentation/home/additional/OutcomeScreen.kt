package com.muriz.pengeluaranku.ui.presentation.home.additional

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryOutcome
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.DatePickers
//import com.muriz.pengeluaranku.ui.presentation.home.additional.component.DatePickers
//import com.muriz.pengeluaranku.ui.presentation.home.additional.component.DatePickers
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.DropDown
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.InputBox
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun OutcomeScreen(modifier: Modifier = Modifier) {
    var iconChange by remember { mutableIntStateOf(R.drawable.question) }
    var selectedCategory by remember { mutableStateOf("") }

    val dataDropDown: MutableList<String> = mutableListOf()
    CategoryOutcome.entries.forEach { dataDropDown.add(it.names) }

    if (selectedCategory.isNotBlank()) {
        when (selectedCategory) {
            CategoryOutcome.MAKANAN.names -> iconChange = CategoryOutcome.MAKANAN.icon
            CategoryOutcome.CEMILAN.names -> iconChange = CategoryOutcome.CEMILAN.icon
            CategoryOutcome.HIBURAN.names -> iconChange = CategoryOutcome.HIBURAN.icon
            CategoryOutcome.MINUMAN.names -> iconChange = CategoryOutcome.MINUMAN.icon
            CategoryOutcome.BELANJA_KEBUTUHAN.names -> iconChange =
                CategoryOutcome.BELANJA_KEBUTUHAN.icon

            CategoryOutcome.KELUARGA.names -> iconChange = CategoryOutcome.KELUARGA.icon
            CategoryOutcome.PAKAIAN.names -> iconChange = CategoryOutcome.PAKAIAN.icon
            CategoryOutcome.TRANSPORTASI.names -> iconChange = CategoryOutcome.TRANSPORTASI.icon
            CategoryOutcome.TABUNGAN.names -> iconChange = CategoryOutcome.TABUNGAN.icon
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(start = 50.dp, end = 50.dp)
    ) {
        Box(
            modifier = modifier
                .background(color = Color.White, shape = CircleShape)
                .size(150.dp)
                .border(2.dp, shape = CircleShape, color = Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconChange),
                contentDescription = "outcome's icon",
                modifier.size(91.dp)
            )
        }
        DropDown(
            dataDropDown = dataDropDown,
            onItemSelected = { item -> selectedCategory = item },
            ket = "Outcome"
        )
        InputBox(inputName = "Nama", modifier = Modifier.padding(top = 5.dp))
        DatePickers()
        InputBox(
            inputName = "Jumlah",
            keyboardType = KeyboardType.Number,
            modifier = modifier.padding(top = 10.dp),
            label = "Rp"
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0x0000000)
@Composable
private fun Test() {
    OutcomeScreen()
}