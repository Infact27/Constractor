@file:OptIn(
    ExperimentalMaterial3Api::class
)

package com.example.constraktor

import android.content.Context
import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.constraktor.ui.theme.ConstraktorTheme
import com.example.constraktor.ui.theme.DarkBlue
import com.example.constraktor.ui.theme.WhiteConnect
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private val db = Firebase.firestore
//private lateinit var firebaseAuth: FirebaseAuth


//Tampilan Login
@Composable
fun HalamanLogin (navController: NavController, context: Context) {

    val nomorHp = remember { mutableStateOf("") }
    val kataSandi = remember { mutableStateOf("") }
    val firebaseAuth = FirebaseAuth.getInstance()
//    val launcher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.StartActivityForResult()
//    ) { result ->
//        if (result.resultCode == ComponentActivity.RESULT_OK) {
//            // User successfully logged in or registered
//            // You can perform necessary actions, e.g., navigate to another screen
//        }
//    }
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
                    .padding(start = 16.dp)
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
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Masukan nomor telepon",
                style = TextStyle(
                    fontSize = 22.sp,
                ),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                color = Color.Black,
                text = "Anda dapat masuk atau membuat akun jika anda baru di Constactor",
            )
            Spacer(Modifier.height(4.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = nomorHp.value,
                onValueChange = { nomorHp.value = it },
                label = {
                    Text(
                        text = "Nomor Telepon",
                        color = Color.Gray,
                    )},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = WhiteConnect
                ),
            )
            Spacer(Modifier.height(4.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = kataSandi.value,
                onValueChange = { kataSandi.value = it},
                label = {
                    Text(
                        text = "Kata Sandi",
                        color = Color.Gray,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = WhiteConnect
                ),
                visualTransformation = PasswordVisualTransformation(),
            )
//            Text(
//                text = "Nomor telepon atau kata sandi yang dimasukan salah",
//                color = Color.Red,
//                fontSize = 14.sp
//            )
            Spacer(Modifier.height(436.dp))
            Button(
                onClick = {
                          onLoginClicked(navController, context, nomorHp.value, kataSandi.value)
//                    onLoginClicked(navController, context, firebaseAuth, phoneNumber.value, kataSandi.value)
                    },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
            ) {
                Text(
                    text = "Berikutnya",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHalamanLogin() {
    val navController = rememberNavController()
    ConstraktorTheme() {
//        HalamanLogin(navController)
    }
}

fun onLoginClicked(navController: NavController, context: Context, nomorHp: String, password: String ){
    val db = FirebaseFirestore.getInstance()
    val usersCollection = db.collection("users")
    val query = usersCollection
        .whereEqualTo("nomor_hp", nomorHp)
        .whereEqualTo("password", password)

    query.get()
        .addOnSuccessListener { querySnapshot ->
            if (!querySnapshot.isEmpty) {
                //login success
                val userDocument = querySnapshot.documents[0]
//                val userData = users(
//                    userDocument.id,
//                    userDocument.data!!["nama"].toString(),
//                    userDocument.data!!["nomor_hp"].toString(),
//                    userDocument.data!!["password"].toString(),
//                    userDocument.data!!["alamat"].toString(),
//                    userDocument.data!!["provinsi"].toString(),
//                    userDocument.data!!["kota"].toString(),
//                    userDocument.data!!["kecamatan"].toString(),
//                    userDocument.data!!["kelurahan"].toString(),
//                    )
                val uId = userDocument.id
//                val nama = userDocument.data!!["nama"].toString()
//                val nomorHp = userDocument.data!!["nomor_hp"].toString()
//                val alamat = userDocument.data!!["alamat"].toString()
//                val provinsi = userDocument.data!!["provinsi"].toString()
//                val kota = userDocument.data!!["kota"].toString()
//                val kecamatan = userDocument.data!!["kecamatan"].toString()
//                val kelurahan = userDocument.data!!["kelurahan"].toString()
//                val bundle = Bundle ()
//                bundle.putString("uId", uId)
//                bundle.putString("nama", nama)
//                bundle.putString("nomorHp", nomorHp)
//                bundle.putString("alamat", alamat)
//                bundle.putString("provinsi", provinsi)
//                bundle.putString("kota", kota)
//                bundle.putString("kecamatan", kecamatan)
//                bundle.putString("kelurahan", kelurahan)
//                val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
//                savedStateHandle?.set("key", userData)
                navController.navigate("HomePage/$uId")
            } else {
                Toast.makeText(context, "Incorrect Email or Password, please try again", Toast.LENGTH_LONG).show()
            }
        }
}
//private fun onLoginClicked(
//    navController: NavController,
//    context: Context,
//    auth: FirebaseAuth,
////    uid: String,
//    email: String,
//    password: String,
////    launcher: ActivityResultLauncher<Intent>
//) {
//    auth.signInWithEmailAndPassword(email, password)
//        .addOnCompleteListener { task ->
//            if (task.isSuccessful) {
////                val uid = firebaseAuth.currentUser?.uid
//                navController.navigate("HomePage")
//                // NavHostController(context).navigate("destination")
//            } else {
////                errorMessage = "Invalid credentials. Please try again."
//            }
//        }
//}



//    val docRef = db.collection("users").document(uid)
//    docRef.get()
//        .addOnSuccessListener { document ->
//            if (document != null) {
//                val email2 = document.data!!["email"].toString()
//                val password2 = document.data!!["password"].toString()
//                if(email1 == email2 && password1 == password2)
//                {
//                    navController.navigate("HomePage")
//                }
//            }
//        }
//        .addOnFailureListener { exception ->
//            Toast.makeText(context, "failed", Toast.LENGTH_SHORT).show()
//        }
