package com.muriz.pengeluaranku.ui.presentation.home.additional

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryOutcome
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily

@Composable
fun OutcomeScreen(modifier: Modifier = Modifier) {
    var iconChange by remember { mutableIntStateOf(R.drawable.question) }
    var isExpanded by remember { mutableStateOf(false) }

    Column {
        Box(
            modifier = modifier
                .background(color = Color.White, shape = CircleShape)
                .size(150.dp), contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = iconChange),
                contentDescription = "outcome's icon",
                modifier.size(91.dp)
            )
        }

    }
}


@Composable
fun DropDownMenu(modifier: Modifier = Modifier) {
    val dataDropDown: MutableList<String> = mutableListOf()
    CategoryOutcome.entries.forEach { dataDropDown.add(it.names) }

    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }
    var textFiledSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedItem,
            readOnly = true,
            onValueChange = { selectedItem = it },
            modifier = modifier
                .fillMaxWidth()
                .onGloballyPositioned { layoutCoordinates ->
                    textFiledSize = layoutCoordinates.size.toSize()
                },
            label = { Text(text = "Kategori Outcome", fontFamily = poppinsFontFamily) },
            trailingIcon = {
                Icon(icon, null, modifier.clickable { expanded = !expanded })
            },
            shape = RoundedCornerShape(5.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .width(with(LocalDensity.current){textFiledSize.width.toDp()})
                .background(color = Color.White),
        ) {
            dataDropDown.forEach { label ->
                DropdownMenuItem(text = { Text(label , fontFamily = poppinsFontFamily)}, onClick = {
                    selectedItem = label
                    expanded = false
                })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun Test() {
    DropDownMenu()
}