package com.muriz.pengeluaranku.entity

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource

import com.muriz.pengeluaranku.R

enum class CategoryOutcome(val icon: Int, val color : Int, val names : String) {
    MAKANAN(R.drawable.food, R.color.makanan, "Makanan"),
    MINUMAN(R.drawable.drink,R.color.minuman,"Minuman"),
    CEMILAN(R.drawable.snack,R.color.cemilan,"Cemilan"),
    HIBURAN(R.drawable.ticket,R.color.hiburan,"Hiburan"),
    KELUARGA(R.drawable.family,R.color.keluarga,"Keluarga"),
    TABUNGAN(R.drawable.savings,R.color.tabungan,"tabungan"),
    PAKAIAN(R.drawable.clothes,R.color.pakaian,"Pakaian"),
    BELANJA_KEBUTUHAN(R.drawable.shopping,R.color.belanja,"Belanja Kebutuhan"),
    TRANSPORTASI(R.drawable.transport,R.color.transport,"Transportasi")
}