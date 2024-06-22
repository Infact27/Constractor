package com.example.constraktor

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.ui.theme.ConstraktorTheme
import com.example.constraktor.ui.theme.DarkBlue

//Halaman masuk atau daftar kurang fungsi untuk tombol
@Composable
fun PreLogin(navController: NavController) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 16.dp, start = 4.dp, top = 8.dp)
        ){
            Image(
                painter = painterResource(R.drawable.backbutton),
                contentDescription = null,
                modifier = Modifier
                    .clickable { navController.navigate("PilihRole") }
                    .padding(start = 16.dp),
            )
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, top = 4.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(60.dp))
            Image(
                painter = painterResource(R.drawable.prelog),
                contentDescription = null,
                modifier = Modifier
                    .size(280.dp)
            )
            Spacer(Modifier.height(40.dp))
            Text(
                text = stringResource(R.string.prelog_header),
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontSize = 22.sp,
                ),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
            Text(
                text = stringResource(R.string.prelog_text),
                modifier = Modifier
                    .padding(start = 12.dp),
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(72.dp))
            //        Tombol Masuk
            Button(
                onClick = { navController.navigate("HalamanMasuk") },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
            ) {
                Text(
                    text = "Masuk",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(Modifier.height(8.dp))
            //        Tombol Daftar
            Button(
                onClick = { navController.navigate("HalamanDaftar") },
                modifier = Modifier
                    .height(48.dp)
                    .border(
                        width = 1.dp,
                        color = DarkBlue,
                        shape = ButtonDefaults.outlinedShape
                    )
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color.White),
            ) {
                Text(
                    text = "Daftar",
                    color = DarkBlue,
                    fontWeight = FontWeight.Bold,
                )
            }
            Text(
                text = "Dengan masuk atau mendaftar, anda menyetujui Kebijakan\n" +
                        "layanan dan kebijakan privasi kami",
                fontWeight = FontWeight.Light,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 12.sp,
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreLoginPreview() {
    val navController = rememberNavController()
    ConstraktorTheme() {
        PreLogin(navController)
    }
}
