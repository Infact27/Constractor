@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.constraktor.Pengguna

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
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


@Composable
fun Order(navController: NavController){
    val uId = ""
    val showDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .background(color = Color.Transparent,)
            .height(120.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text("Konfirmasi Pembatalan") },
                text = { Text("Apakah anda yakin untuk membatalkan pesanan?") },
                confirmButton = {
                    Button(
                        onClick = { showDialog.value = false },
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .width(80.dp)
                    ) {
                        Text("Iya")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = { showDialog.value = false },
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .width(80.dp)
                    ) {
                        Text("Tidak")
                    }
                }
            )
        }
    }

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
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(120.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.profillight),
                        contentDescription = null,
                        modifier = Modifier
                            .width(136.dp)
                            .fillMaxHeight()
                    )
                    Column(Modifier.fillMaxWidth()){
                        Text(
                            text = "Agung Syah",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Perbaikan dan Instalasi",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Buka Profil...",
                            Modifier
                                .padding(top = 48.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.End,
                            color = Color.Black,
                            fontSize = 12.sp,
                            textDecoration = TextDecoration.Underline,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                ){
                    Image(
                        painter = painterResource(R.drawable.notatagihan),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 16.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.hasilpengerjaan),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp)
                    )
                }
                Text(
                    text = "Foto Permasalahan",
                    Modifier
                        .padding(start = 36.dp, top = 16.dp)
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
                        painter = painterResource(R.drawable.porto2),
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
                        painter = painterResource(R.drawable.porto2),
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
                Text(
                    text = "Deskripsi Permasalahan",
                    Modifier
                        .padding(start = 36.dp)
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "Pembangunan dinding untuk sekat halaman belakang",
                    Modifier
                        .padding(start = 36.dp, top = 20.dp, end = 36.dp)
                        .fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Spacer(Modifier.height(36.dp))
                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                        .height(36.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Konsultasi",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Button(
                    onClick = { navController.navigate("Bill") },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                        .height(36.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Konfirmasi Pekerjaan Selesai",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Button(
                    onClick = { showDialog.value = true },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .height(36.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = DarkBlue,
                            shape = ButtonDefaults.outlinedShape
                        )
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.White),
                ) {
                    Text(
                        text = "Batalkan Pesanan",
                        color = DarkBlue,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewOrder() {
    val navController = rememberNavController()
    Order(navController)
}

@Composable
fun PopupBatal(showDialog: Boolean) {

}