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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.R
import com.example.constraktor.ui.theme.DarkBlue


@Composable
fun FormAlamat(navController: NavController){
    val uId = ""
    val deskripsi = remember { mutableStateOf("") }
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
                    .clickable { navController.navigate("HomePage/$uId") }
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
                Text(
                    text = "Perbaikan dan Instalasi",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Column (Modifier.padding(start = 16.dp, end = 16.dp)){
                    Text(
                        text = "Alamat",
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = Stroke.DefaultMiter
                                )
                            },
                    ) {
                        Text(
                            text = "Jl. Coklat No. 9",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "Provinsi",
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = Stroke.DefaultMiter
                                )
                            },
                    ) {
                        Text(
                            text = "Jawa Timur",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "Kota/Kabupaten",
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = Stroke.DefaultMiter
                                )
                            },
                    ) {
                        Text(
                            text = "Kota Malang",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "Kecamatan",
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = Stroke.DefaultMiter
                                )
                            },
                    ) {
                        Text(
                            text = "Blimbing",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = "Kelurahan",
                        modifier = Modifier.padding(top = 16.dp),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Black
                    )
                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                            .drawBehind {
                                drawLine(
                                    color = Color.LightGray,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = Stroke.DefaultMiter
                                )
                            },
                    ) {
                        Text(
                            text = "Arjosari",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                }
                Spacer(Modifier.height(260.dp))

                Button(
                    onClick = { navController.navigate("FormulirPemesanan") },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .height(48.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Simpan",
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
fun PreviewFormAlamat() {
    val navController = rememberNavController()
    FormAlamat(navController)
}