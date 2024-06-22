package com.example.constraktor.Pengguna

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.R
import com.example.constraktor.mitra


@Composable
fun HomePage(navController: NavController, uId: String) {
//    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
//    val bundle = savedStateHandle?.get<Bundle>("key")
//    savedStateHandle?.set("key", bundle)
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxSize(),
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ){
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
                    .clickable { navController.navigate("ProfilUser/$uId") }
            )
        }
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(size = 16.dp))
                .fillMaxSize()
                .padding(top = 4.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(R.drawable.iklan),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .height(160.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            ) {
                Column (modifier = Modifier
                    .fillMaxHeight(),
//                    .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.perbaikan_dan_instalasi),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { navController.navigate("Perbaikan") }
                            .width(80.dp)
                            .height(80.dp)
                    )
                    Text(
                        text = "Perbaikan &\nInstalasi",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
                Column (modifier = Modifier
                    .fillMaxHeight(),
//                    .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.renovasi_dan_pembangunan),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { navController.navigate("Pembangunan") }
                            .width(80.dp)
                            .height(80.dp)
                    )
                    Text(
                        text = "Renovasi &\nPembangunan",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
                Column (modifier = Modifier
                    .fillMaxHeight(),
//                    .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Image(
                        painter = painterResource(R.drawable.desain),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { navController.navigate("Desain") }
                            .width(80.dp)
                            .height(80.dp)
                    )
                    Text(
                        text = "Desain",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column(
                Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                    .height(344.dp)
                    .clickable { navController.navigate("LihatMitra")}
                    .verticalScroll(
                        state = rememberScrollState(),
                        enabled = true,
                    ),
                horizontalAlignment = Alignment.Start,
            ) {
                for (profilMitra in mitra) {
                    Row (
                        Modifier
                            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ){
                        Image(
                            painter = painterResource(profilMitra.foto),
                            contentDescription = null,
                            Modifier
                                .padding(end = 8.dp)
                                .size(64.dp)
                        )
                        Column {
                            Text(text = profilMitra.nama, color = Color.Black)
                            Text(text = profilMitra.job, color = Color.Black)
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
                        .clickable { navController.navigate("HomePage/$uId") }
                        .height(64.dp)
                        .width(64.dp)
                )
                Image(
                    painter = painterResource(R.drawable.pesanan),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { navController.navigate("PesananPage") }
                        .height(64.dp)
                        .width(64.dp)
                )
                Image(
                    painter = painterResource(R.drawable.pesan),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { navController.navigate("PesanPage") }
                        .height(64.dp)
                        .width(64.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomePage() {
    val navController = rememberNavController()
//    HomePage(navController)
}