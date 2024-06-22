package com.example.constraktor.Mitra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun DetailPesanan(navController: NavController){
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
                text = { Text("Apakah anda yakin untuk Menolak pesanan?") },
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

    Column (
        Modifier
            .fillMaxSize()
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .drawBehind {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                    )
                }
        ){
            Image(
                painter = painterResource(R.drawable.backbutton2),
                contentDescription = null,
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .size(48.dp)
                    .padding(start = 16.dp)
            )
            Spacer(Modifier.width(104.dp))
            Text(
                text = "Detail Pesanan",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black

            )
        }
            Column(modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(100.dp)
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
                            text = "Jason Siangeng",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "Perbaikan dan Instalasi",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }
                }
                Text(
                    text = "Alamat",
                    Modifier
                        .padding(start = 36.dp,)
                        .fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "Jl. Coklat No.9, Arjosari, Blimbing, Kota Malang, Jawa Timur",
                    Modifier
                        .padding(start = 36.dp)
                        .fillMaxWidth(),
                    color = Color.Black
                )
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
                        .padding(start = 36.dp, top = 16.dp)
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
                Spacer(Modifier.height(80.dp))
                Button(
                    onClick = { navController.navigate("ProsesPengerjaan") },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                        .height(36.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Terima Pesanan",
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
                        text = "Tolak Pesanan",
                        color = DarkBlue,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDetailPesanan() {
    val navController = rememberNavController()
    DetailPesanan(navController)
}