package com.example.constraktor.Pengguna

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


@Composable
fun PesanPage(navController: NavController) {
    val uId = ""
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
                    .clickable { navController.navigate("HomePage/$uId") }
                    .size(48.dp)
                    .padding(start = 16.dp)
            )
            Spacer(Modifier.width(108.dp))
            Text(
                text = "Pesan",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black

            )
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 16.dp, start = 4.dp)
                .height(60.dp)) {
            Spacer(Modifier.width(20.dp))
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .height(564.dp)
                .fillMaxWidth()
        ){
            Image(
                painter = painterResource(R.drawable.pengisi),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
                    .height(136.dp)
            )
            Text(
                text = "Ayo pesan sekarang!",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Mitra kami akan dengan senang hati menolong kamu.",
                color = Color.Black
            )
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPesanPage() {
    val navController = rememberNavController()
    PesanPage(navController)
}