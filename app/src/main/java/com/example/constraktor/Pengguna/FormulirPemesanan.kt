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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
fun FormulirPemesanan(navController: NavController){
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
                Text(
                    text = "Alamat",
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Jl. Coklat No.9, Arjosari, Blimbing, Kota Malang, Jawa Timur",
                        Modifier
                            .width(240.dp)
                            .height(36.dp),
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.editprofil),
                        contentDescription = null,
                        Modifier.size(18.dp)
                            .clickable { navController.navigate("FormAlamat") }
                    )
                }
                Text(
                    text = "Foto Permasalahan",
                    modifier = Modifier
                        .padding(start = 16.dp, top = 32.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Image(
                    painter = painterResource(R.drawable.tambahkanfoto),
                    contentDescription = null,
                    Modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .height(112.dp)
                )
                Text(
                    text = "Deskripsi Permasalahan",
                    modifier = Modifier
                        .padding(start = 16.dp, top = 32.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Box(modifier = Modifier.fillMaxWidth()) {
                    TextField(
                        value = deskripsi.value,
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        ),
                        onValueChange = { deskripsi.value = it },
                        textStyle = TextStyle.Default.copy(
                            lineHeight = 20.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 160.dp)
                            .padding(horizontal = 16.dp),
                        maxLines = 4
                    )
                    Column(
                        modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                    ) {
                        repeat(4) {
                            Divider(
                                color = Color.LightGray,
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
                            )
                        }
                    }
                }
                Spacer(Modifier.height(100.dp))
                Button(
                    onClick = { navController.navigate("Order") },
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
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFormulirPemesanan() {
    val navController = rememberNavController()
    FormulirPemesanan(navController)
}