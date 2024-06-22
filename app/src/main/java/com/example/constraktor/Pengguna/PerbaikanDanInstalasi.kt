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
import androidx.compose.foundation.layout.wrapContentHeight
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
fun Perbaikan (navController: NavController){
    val uId = ""
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxSize(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .drawBehind {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                    )
                }
                .height(40.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.backbutton2),
                contentDescription = null,
                modifier = Modifier
                    .clickable { navController.navigate("HomePage/$uId") }
                    .padding(start = 16.dp)
            )
            Text(
                text = "Perbaikan dan Instalasi",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Image(
                painter = painterResource(R.drawable.berandabiru),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.navigate("HomePage/$uId") }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.pembanguandinding),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(160.dp)
                    .clickable { navController.navigate("PembangunanDinding") }
            )
            Image(
                painter = painterResource(R.drawable.pembangunanstruktur),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(160.dp)
                    .clickable { navController.navigate("PembangunanStruktur") }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(160.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.pemasanganlantai),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(160.dp)
                    .clickable { navController.navigate("PemasanganLantai") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(R.drawable.pembuatankanopi),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier
                    .size(160.dp)
                    .clickable { navController.navigate("PembuatanKanopi") }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPerbaikan() {
    val navController = rememberNavController()
    Perbaikan(navController)
}