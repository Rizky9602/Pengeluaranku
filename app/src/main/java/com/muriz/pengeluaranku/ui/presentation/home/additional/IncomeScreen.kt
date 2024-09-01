package com.muriz.pengeluaranku.ui.presentation.home.additional

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryIncome
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.ConfirmationButton
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.DatePickers
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.DropDown
import com.muriz.pengeluaranku.ui.presentation.home.additional.component.InputBox

@Composable
fun IncomeScreen(modifier: Modifier = Modifier,navController: NavController) {
    var iconChange by remember { mutableIntStateOf(R.drawable.question) }
    var selectedCategory by remember { mutableStateOf("") }

    val dataDropDown: MutableList<String> = mutableListOf()
    CategoryIncome.entries.forEach { dataDropDown.add(it.names) }


    if (selectedCategory.isNotBlank()) {
        when (selectedCategory) {
            CategoryIncome.GAJI.names -> iconChange = CategoryIncome.GAJI.icon
            CategoryIncome.THR.names -> iconChange = CategoryIncome.THR.icon
            CategoryIncome.BONUS.names -> iconChange = CategoryIncome.BONUS.icon
            CategoryIncome.FREELANCE.names -> iconChange = CategoryIncome.FREELANCE.icon
            CategoryIncome.ORANGTUA.names -> iconChange = CategoryIncome.ORANGTUA.icon
            CategoryIncome.LAIN.names -> iconChange = CategoryIncome.LAIN.icon
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(start = 60.dp, end = 60.dp)
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
                contentDescription = "income's icon",
                modifier.size(91.dp)
            )
        }
        DropDown(
            dataDropDown = dataDropDown,
            onItemSelected = { item -> selectedCategory = item },
            ket = "Income"
        )
        InputBox(inputName = "Nama", modifier = Modifier.padding(top = 5.dp))
        DatePickers()
        InputBox(
            inputName = "Jumlah",
            keyboardType = KeyboardType.Number,
            modifier = modifier.padding(top = 10.dp),
            label = "Rp"
        )
        ConfirmationButton(modifier = modifier.padding(top = 40.dp), navController = navController)
    }
}