package com.muriz.pengeluaranku.entity

import java.sql.Date

data class Outcome(
    val id  : Int,
    val category : CategoryOutcome,
    val name : String,
    val date : Date,
    val quantity : Int
    )
