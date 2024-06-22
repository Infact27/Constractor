package com.example.constraktor.Mitra

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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.constraktor.ui.theme.WhiteConnect
import com.example.constraktor.user

@Composable
fun HomePageMitra(navController: NavController){
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            Image(
                painter = painterResource(R.drawable.menubutton),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate("ProfilMitra") }
            )
        }
        Row(
            Modifier
                .height(100.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.profil),
                contentDescription = null,
                Modifier
                    .padding(start = 16.dp)
                    .size(80.dp)
            )
            Column(
                Modifier
                    .padding(start = 16.dp)
                    .wrapContentSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Agung Syah", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Perbaikan dan Instalasi", color = Color.Black, fontSize = 15.sp)
            }
        }
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
                .padding(start = 36.dp)
                .fillMaxWidth(),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )
        Column(
            Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(232.dp)
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




        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .drawBehind {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                    )
                }
        ){
            Image(
                painter = painterResource(R.drawable.beranda),
                contentDescription = null,
                modifier = Modifier
                    .clickable { navController.navigate("HomePageMitra") }
                    .height(64.dp)
                    .width(64.dp)
            )
            Image(
                painter = painterResource(R.drawable.pesanan),
                contentDescription = null,
                modifier = Modifier
                    .clickable { navController.navigate("PesananMitra") }
                    .height(64.dp)
                    .width(64.dp)
            )
            Image(
                painter = painterResource(R.drawable.pesan),
                contentDescription = null,
                modifier = Modifier
                    .clickable {  }
                    .height(64.dp)
                    .width(64.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfilMitra() {
    val navController = rememberNavController()
    HomePageMitra(navController)
}