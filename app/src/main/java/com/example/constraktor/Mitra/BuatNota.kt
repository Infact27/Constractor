@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.constraktor.Mitra

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
fun BuatNota(navController: NavController){
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
                text = "Buat Nota Tagihan",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 18.sp
            )
            Image(
                painter = painterResource(R.drawable.berandaputih),
                contentDescription = null,
                Modifier
                    .clickable { navController.navigate("HomePageMitra") }
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
                    text = "Jasa Pengerjaan",
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
                        text = "Lama Pengerjaan",
                        Modifier
                            .width(240.dp)
                            .height(20.dp),
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "Biaya per-hari",
                        Modifier
                            .width(240.dp)
                            .height(20.dp),
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = "Hari",
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Column {
                        TextField(
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            value = deskripsi.value,
                            onValueChange = { deskripsi.value = it },
                            textStyle = TextStyle.Default.copy(
                                lineHeight = 20.sp
                            ),
                            modifier = Modifier
                                .width(120.dp)
                                .height(20.dp),
                            maxLines = 1
                        )
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .width(120.dp)
                        )
                    }
                    Text(
                        text = "Rp. ",
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Column {
                        TextField(
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            value = deskripsi.value,
                            onValueChange = { deskripsi.value = it },
                            textStyle = TextStyle.Default.copy(
                                lineHeight = 20.sp
                            ),
                            modifier = Modifier
                                .width(120.dp)
                                .height(20.dp),
                            maxLines = 1
                        )
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .width(120.dp)
//                                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        )
                    }
                }
                Text(
                    text = "Material",
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
                        text = "Nama Material",
                        Modifier
                            .width(240.dp)
                            .height(20.dp),
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Text(
                        text = "Biaya per item/kg/m/dll",
                        Modifier
                            .width(240.dp)
                            .height(20.dp),
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    Column {
                        TextField(
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            value = deskripsi.value,
                            onValueChange = { deskripsi.value = it },
                            textStyle = TextStyle.Default.copy(
                                lineHeight = 20.sp
                            ),
                            modifier = Modifier
                                .width(160.dp)
                                .height(20.dp),
                            maxLines = 1
                        )
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .width(120.dp)
//                                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        )
                    }
                    Text(
                        text = "Rp. ",
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Column {
                        TextField(
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            value = deskripsi.value,
                            onValueChange = { deskripsi.value = it },
                            textStyle = TextStyle.Default.copy(
                                lineHeight = 20.sp
                            ),
                            modifier = Modifier
                                .width(120.dp)
                                .height(20.dp),
                            maxLines = 1
                        )
                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier
                                .width(120.dp)
//                                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                        )
                    }
                }
                Button(
                    onClick = {},
                    Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                        .height(36.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = ButtonDefaults.outlinedShape
                        )
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.White),
                ) {
                    Text(
                        text = "+ Tambah Material",
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.height(140.dp))
                Text(
                    text = "Foto Nota Pembelian Material",
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
                Spacer(modifier = Modifier.height(60.dp))
                Button(
                    onClick = { navController.navigate("Order") },
                    Modifier
                        .padding(start = 24.dp, end = 24.dp)
                        .height(36.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                ) {
                    Text(
                        text = "Kirim Nota Tagihan",
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
fun PreviewBuatNota() {
    val navController = rememberNavController()
    BuatNota(navController)
}