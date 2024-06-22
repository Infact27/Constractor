package com.example.constraktor.Pengguna

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.R
import com.example.constraktor.ui.theme.DarkBlue
import com.example.constraktor.user


@Composable
fun LihatMitra(navController: NavController){
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
                text = "Profil Mitra",
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
                .padding(top = 60.dp)
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
                Spacer(modifier = Modifier.height(136.dp))
                Column(
                    Modifier
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = Stroke.DefaultMiter
                            )
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, 0f),
                                end = Offset(size.width, 0f),
                                strokeWidth = Stroke.DefaultMiter
                            )
                        }
                        .padding(top = 20.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "Portofolio",
                        Modifier
                            .padding(start = 36.dp)
                            .fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Row(
                        Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .height(120.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(R.drawable.porto1),
                            contentDescription = null,
                            Modifier
                                .fillMaxHeight()
                                .size(80.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.porto2),
                            contentDescription = null,
                            Modifier
                                .fillMaxHeight()
                                .size(80.dp)
                        )
                        Image(
                            painter = painterResource(R.drawable.porto3),
                            contentDescription = null,
                            Modifier
                                .fillMaxHeight()
                                .size(80.dp)
                        )
                    }
                    Text(
                        text = "Lihat Lainnya...",
                        Modifier
                            .padding(end = 36.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End,
                        color = Color.Black,
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Text(
                    text = "Review",
                    Modifier
                        .padding(start = 36.dp, top = 20.dp)
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Column(
                    Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        .fillMaxSize()
                        .verticalScroll(
                            state = rememberScrollState(),
                            enabled = true,
                        ),
                    horizontalAlignment = Alignment.Start,
                ) {
                    for (profilUser in user) {
                        Row (
                            Modifier
                                .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ){
                            Image(
                                painter = painterResource(profilUser.foto),
                                contentDescription = null,
                                Modifier
                                    .padding(end = 8.dp)
                                    .size(64.dp)
                            )
                            Column {
                                Row (
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ){
                                    Text(text = profilUser.nama, color = Color.Black)
                                }
                                Text(
                                    text = profilUser.review,
                                    color = Color.Black,
                                    fontSize = 12.sp,
                                )
                            }
                        }
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .height(80.dp)
                    .drawBehind {
                        drawLine(
                            color = Color.LightGray,
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f),
                            strokeWidth = Stroke.DefaultMiter
                        )
                    }
            ) {
                Button(
                    onClick = { navController.navigate("FormulirPemesanan") },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .height(48.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Pesan Sekarang",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(R.drawable.profillight),
                    contentDescription = null,
                    Modifier.size(120.dp)
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "Agung Syah",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = "Perbaikan dan Instalasi",
                    color = Color.Black
                )
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLihatMitra() {
    val navController = rememberNavController()
    LihatMitra(navController)
}



