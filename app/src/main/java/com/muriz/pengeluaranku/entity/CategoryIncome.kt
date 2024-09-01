package com.muriz.pengeluaranku.entity

import com.muriz.pengeluaranku.R

enum class CategoryIncome(val icon: Int, val names : String) {
    GAJI(R.drawable.gaji, "Gaji"),
    FREELANCE(R.drawable.freelancer, "Freelance"),
    BONUS(R.drawable.bonus, "Bonus"),
    THR(R.drawable.thr, "THR"),
    ORANGTUA(R.drawable.orang_tua, "Orang Tua"),
    LAIN(R.drawable.lain,"Lain - lain")
}