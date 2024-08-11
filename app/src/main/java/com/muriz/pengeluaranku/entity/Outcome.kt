package com.muriz.pengeluaranku.entity

import java.sql.Date
import java.time.LocalDate

data class Outcome(
    val id  : Int,
    val category : CategoryOutcome,
    val name : String,
    val date : LocalDate,
    val quantity : Int
    )
