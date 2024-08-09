package com.muriz.pengeluaranku.entity

import java.sql.Date

data class Income(
    val id : Int,
    val category: CategoryIncome,
    val name : String,
    val date : Date,
    val quantity : Int
    )