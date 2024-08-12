package com.muriz.pengeluaranku.ui.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.ConstraintLayout
import com.muriz.pengeluaranku.R
import com.muriz.pengeluaranku.entity.CategoryOutcome
import com.muriz.pengeluaranku.entity.Outcome
import com.muriz.pengeluaranku.ui.theme.poppinsFontFamily
import java.time.LocalDate

@Composable
fun HomeScreen(
    name: String,
    desc: String,
    image: Int,
    saldo: Int,
    income: Int,
    outcome: Int,
    dataOutcome: List<Outcome>
) {
    HomeScreenComponent(
        name =name,
        desc =desc,
        image =image,
        saldo =saldo,
        income =income,
        outcome =outcome,
        dataOutcome =dataOutcome
    )
}

@Composable
fun HomeScreenComponent(
    name: String,
    desc: String,
    image: Int,
    saldo: Int,
    income: Int,
    outcome: Int,
    dataOutcome: List<Outcome>,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Box(
            modifier = modifier
                .background(color = colorResource(id = R.color.lightBlue))
                .fillMaxHeight()
                .padding(paddingValues)
        ) {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                item {
                    Spacer(
                        modifier = modifier
                            .background(color = colorResource(id = R.color.deepBlue))
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                }

                item {
                    Box(
                        modifier = modifier
                            .background(color = colorResource(id = R.color.deepBlue))
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        Profile(name = name, desc = desc, image = image)
                    }
                }

                item {
                    Spacer(
                        modifier = modifier
                            .background(color = colorResource(id = R.color.deepBlue))
                            .fillMaxWidth()
                            .height(10.dp)
                    )
                }

                item {
                    Box {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.5.dp)
                                .clip(RectangleShape)
                                .background(
                                    colorResource(
                                        id = R.color.deepBlue
                                    )
                                )
                                .align(Alignment.TopCenter)
                        )
                        WalletCard(saldo = saldo, income = income, outcome = outcome)
                    }
                }

                item {
                    Spacer(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(10.dp)
                    )
                }

                item {
                    Text(
                        text = "Riwayat Transaksi",
                        fontFamily = poppinsFontFamily,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = modifier.padding(start = 20.dp)
                    )
                }

                items(dataOutcome) { dataOutcome ->
                    Box(modifier = modifier.padding(10.dp)) {
                        OutcomeHistory(
                            icon = dataOutcome.category.icon,
                            name = dataOutcome.name,
                            date = dataOutcome.date,
                            quantity = dataOutcome.quantity
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun Test() {
    val data = listOf(
        Outcome(
            name = "nasi padang",
            quantity = 10008000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.CEMILAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        ),
        Outcome(
            name = "nasi padang",
            quantity = 18000,
            date = LocalDate.now(),
            category = CategoryOutcome.MAKANAN,
            id = 1
        )
    )

    HomeScreenComponent(
        name = "Muhammad Rizky",
        desc = "Tetap hemat tahun depan akad nikah",
        image = R.drawable.pp,
        saldo = 13500000,
        income = 1000000,
        outcome = 500000,
        dataOutcome = data
    )
}
