package com.example.constraktor.Mitra

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
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
fun EditProfilMitra(navController: NavController) {
    Column (
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
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
                text = "Edit Profil",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Text(
            text = "Foto Profil",
            modifier = Modifier
                .padding(start = 34.dp, bottom = 8.dp),
            fontSize = 10.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
        Row(verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(end = 16.dp, start = 4.dp,)
                .height(68.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.width(20.dp))
            Image(
                painter = painterResource(R.drawable.profil),
                contentDescription = null,
                modifier = Modifier
                    .size(68.dp)
            )
            Column (
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .width(264.dp)
                    .padding(start = 8.dp)
            ){
                Text(
                    text = "Masukan foto terbaik anda! Orang lain akan\n" +
                            "dapat melihatnya. ",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(start = 20.dp),
                    color = Color.Black
                )
            }
        }
        Text(
            text = "Tambah Foto",
            modifier = Modifier
                .padding(start = 28.dp,),
            fontSize = 10.sp,
            fontWeight = FontWeight.Light,
            color = Color.Black
        )
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = "Nama",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
                Row (
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
                    Text(
                        text = "Agung Syah",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Text(
                    text = "Nomor Telepon",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
                Row (
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
                    Text(
                        text = "+62 89 609 0022 44",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Text(
                    text = "Email",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light
                )
                Row (
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
                    Text(
                        text = "ferdiansyayahoo@gmail.com",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Text(
                    text = "Alamat",
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
                Row (
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
                Row (
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
                Row (
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
                Row (
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
                Row (
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
                    Text(
                        text = "Arjosari",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Spacer(modifier = (Modifier.height(84.dp)))
                Button(
                    onClick = { navController.navigate("HomePageMitra") },
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
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
fun PreviewEditMitra() {
    val navController = rememberNavController()
    EditProfilMitra(navController)
}
