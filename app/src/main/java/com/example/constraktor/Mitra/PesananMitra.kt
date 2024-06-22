package com.example.constraktor.Mitra

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun PesananMitra(navController: NavController) {
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
                    .clickable { navController.popBackStack() }
                    .size(48.dp)
                    .padding(start = 16.dp)
            )
            Spacer(Modifier.width(104.dp))
            Text(
                text = "Pesanan",
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
            Text(
                text = "Baru",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = "Berlangsung",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(Modifier.width(16.dp))
            Text(
                text = "Riwayat",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
        ){
            Row (Modifier.fillMaxWidth()){
                Image(
                    painter = painterResource(R.drawable.profillight),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .height(76.dp)
                )
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ){
                    Text(
                        text = "Jason Siangeng",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Perbaikan dan Installasi",
                        color = Color.Black
                    )
                    Text(
                        text = "Lihat Detail...",
                        color = Color.Black,
                        modifier = Modifier
                            .clickable { navController.navigate("DetailPesanan") }
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.End,
                        textDecoration = TextDecoration.Underline
                    )
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
fun PreviewPesananMitra() {
    val navController = rememberNavController()
    PesananMitra(navController)
}