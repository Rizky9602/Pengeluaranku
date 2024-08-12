package com.muriz.pengeluaranku.entity

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

import com.muriz.pengeluaranku.R

enum class CategoryOutcome(val icon: Int, val color : Int) {
    MAKANAN(R.drawable.food, R.color.makanan),
    MINUMAN(R.drawable.drink,R.color.minuman),
    CEMILAN(R.drawable.snack,R.color.cemilan),
    HIBURAN(R.drawable.ticket,R.color.hiburan),
    KELUARGA(R.drawable.family,R.color.keluarga),
    TABUNGAN(R.drawable.savings,R.color.tabungan),
    PAKAIAN(R.drawable.clothes,R.color.pakaian),
    BELANJA_KEBUTUHAN(R.drawable.shopping,R.color.belanja),
    TRANSPORTASI(R.drawable.transport,R.color.transport)
}