@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.constraktor.Pengguna

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.R
import com.example.constraktor.ui.theme.DarkBlue


@Composable
fun Bill(navController: NavController){
    val uId = ""
    Column (
        Modifier
            .fillMaxSize()
            .background(
                color = DarkBlue,
            )
    ){
        Row(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.backbuttonputih),
                contentDescription = null,
                Modifier
                    .clickable { navController.popBackStack() }
                    .size(36.dp)
            )
            Text(
                text = "Formulir Pemesanan",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(R.drawable.berandaputih),
                contentDescription = null,
                Modifier
                    .clickable { navController.navigate("HomePage/") }
                    .size(36.dp)
            )
        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
            ) {
                Column(
                    Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ){
                    Row(
                        Modifier.fillMaxWidth(),
                        Arrangement.SpaceBetween
                    ) {
                        Column (Modifier.padding(end = 24.dp)){
                            Text(text = "Jasa", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "Transportasi", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Pengerjaan", color = Color.Black, fontSize = 10.sp)
                        }
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(end = 24.dp)
                        ){
                            Text(text = "Kuantitas", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "-", color = Color.Black, fontSize = 10.sp)
                            Text(text = "7 Hari", color = Color.Black, fontSize = 10.sp)
                        }
                        Column (
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier.padding(end = 24.dp)
                        ){
                            Text(text = "Harga", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "Rp. 15.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 100.000", color = Color.Black, fontSize = 10.sp)
                        }
                        Column (horizontalAlignment = Alignment.End){
                            Text(text = "Total", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "Rp. 15.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 100.000", color = Color.Black, fontSize = 10.sp)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 32.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Total Biaya", color = Color.Black, fontWeight = FontWeight.Bold,)
                        Text(text = "Rp. 715.000", color = Color.Black, fontWeight = FontWeight.Bold,)
                    }
                    Row(
                        Modifier.fillMaxWidth(),
                        Arrangement.SpaceBetween
                    ) {
                        Column (Modifier.padding(end = 24.dp)){
                            Text(text = "Material", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "Bata Merah", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Semen Gresik", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Pasir", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Plamir", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Cat", color = Color.Black, fontSize = 10.sp)
                        }
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(end = 24.dp)
                        ){
                            Text(text = "Kuantitas", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "500", color = Color.Black, fontSize = 10.sp)
                            Text(text = "2 sak", color = Color.Black, fontSize = 10.sp)
                            Text(text = "1 pickup", color = Color.Black, fontSize = 10.sp)
                            Text(text = "5 Kg", color = Color.Black, fontSize = 10.sp)
                            Text(text = "10 Kg", color = Color.Black, fontSize = 10.sp)
                        }
                        Column (
                            horizontalAlignment = Alignment.End,
                            modifier = Modifier.padding(end = 24.dp)
                        ){
                            Text(text = "Harga", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "Rp. 1.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 100.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 500.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 20.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 150.000", color = Color.Black, fontSize = 10.sp)
                        }
                        Column (horizontalAlignment = Alignment.End){
                            Text(text = "Total", color = Color.Black, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
                            Text(text = "Rp. 500.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 200.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 500.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 100.000", color = Color.Black, fontSize = 10.sp)
                            Text(text = "Rp. 150.000", color = Color.Black, fontSize = 10.sp)
                        }
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 32.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Total Biaya", color = Color.Black, fontWeight = FontWeight.Bold,)
                        Text(text = "Rp. 1.450.000", color = Color.Black, fontWeight = FontWeight.Bold,)
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 32.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Total Semua Biaya", color = Color.Black, fontWeight = FontWeight.Bold,)
                        Text(text = "Rp. 2.165.000", color = Color.Black, fontWeight = FontWeight.Bold,)
                    }
                }
                Spacer(Modifier.height(120.dp))
                Button(
                    onClick = { navController.navigate("HomePage/$uId") },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .height(48.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Selesaikan",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBill() {
    val navController = rememberNavController()
    Bill(navController)
}