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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.R
import com.example.constraktor.mitra
import com.example.constraktor.ui.theme.DarkBlue
import com.example.constraktor.ui.theme.GrayText
import com.example.constraktor.ui.theme.PutihTulang


@Composable
fun PilihTukang (navController: NavController, judulHeader: String){
    val uId = ""

    val judulHeader = judulHeader
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxSize(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.backbutton2),
                contentDescription = null,
                modifier = Modifier
                    .clickable { navController.popBackStack() }
                    .padding(start = 16.dp)
            )
            Text(
                text = judulHeader,
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
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                Modifier.height(36.dp),
                colors = ButtonDefaults.buttonColors(containerColor = PutihTulang),
            ) {
                Text(text = "Dekat Saya",
                color = GrayText)
            }
            Spacer(Modifier.width(16.dp))
            Button(
                onClick = { /*TODO*/ },
                Modifier.height(36.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue)
            ) {
                Text(text = "Penilaian", fontSize = 12.sp)
            }
        }
        Text(
            text = "Biaya yang ditampilkan adalah biaya transportasi \n" +
                    "dari lokasi mitra ke lokasi anda ",
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Column(
            Modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp)
                .fillMaxSize()
                .verticalScroll(
                    state = rememberScrollState(),
                    enabled = true,
                ),
            horizontalAlignment = Alignment.Start,
        ) {
            for (profilMitra in mitra) {
                Row (
                    Modifier
                        .clickable { navController.navigate("LihatMitra")}
                        .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
                        .fillMaxWidth(),
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
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ){
                            Text(text = profilMitra.nama, color = Color.Black, fontWeight = FontWeight.Bold)
                            Text(text = "Rp. 10.000", color = DarkBlue, fontWeight = FontWeight.Bold)
                        }
                        Text(text = profilMitra.job, color = Color.Black)
                        Text(
                            text = "25 Km",
                            Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.End,
                            fontSize = 10.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPembangunanDinding() {
    val navController = rememberNavController()
    val judulHeader = "Pembangunan Dinding"
    PilihTukang(navController, judulHeader)
}