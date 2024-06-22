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
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun HalamanRegister (navController: NavController, context: Context) {
//    lateinit var auth: FirebaseAuth
    val context = context
//    auth = Firebase.auth
//    val currentUser = auth.currentUser
//    if (currentUser != null) {
//        navController.currentDestination
//    }
    val nomorHp = remember { mutableStateOf("") }
    val kataSandi = remember { mutableStateOf("") }
    val konfirmasiKataSandi = remember { mutableStateOf("") }

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
                text = "Buat akun sekarang",
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
                onValueChange = { nomorHp.value = it},
                label = {
                    Text(
                        text = "nomor hp",
                        color = Color.Gray,
                    )
                },
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
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = konfirmasiKataSandi.value,
                onValueChange = { konfirmasiKataSandi.value = it},
                label = {
                    Text(
                        text = "Masukkan ulang Kata Sandi",
                        color = Color.Gray,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = WhiteConnect
                ),
                visualTransformation = PasswordVisualTransformation(),
            )
//            Text(
//                text = "Nomor telepon sudah terdaftar atau kata sandi tidak sesuai",
//                color = Color.Red,
//                fontSize = 14.sp
//            )
            Spacer(Modifier.height(380.dp))
            Button(
//                onClick = {navController.navigate("HomePage")},
                onClick = {
                    onRegisterClicked(navController, nomorHp.value, kataSandi.value, context
//                        navController,
//                        auth,
//                        email.value,
//                        kataSandi.value,
//                        context
                    )
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

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun PreviewHalamanRegister() {
    val navController = rememberNavController()
    ConstraktorTheme() {
//        HalamanRegister(navController)
    }
}

private fun onRegisterClicked(navController: NavController, nomorHp: String, password: String, context: Context){
    val pengguna = users(id = "1" ,nama = "", email = "", nomorHp, password, alamat = "", provinsi = "", kota = "", kecamatan = "", kelurahan = "")
    saveUser(pengguna, context)
    navController.navigate("HomePage/${pengguna.id}")

}

private fun saveUser (user: users, context: Context) = CoroutineScope(Dispatchers.IO).launch {
    try {
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("users")
        collectionRef.add(user).addOnSuccessListener { documentReference ->
            val documentId = documentReference.id
            val updatedDocument = hashMapOf(
                "id" to documentId,
                "nama" to user.nama,
                "email" to user.email,
                "nomor_hp" to user.nomorhp,
                "password" to user.password,
                "alamat" to user.alamat,
                "provinsi" to user.provinsi,
                "kota" to user.kota,
                "kecamatan" to user.kecamatan,
                "kelurahan" to user.kelurahan
            )

            // Update the document with the new data
            documentReference.set(updatedDocument).addOnSuccessListener {
                Toast.makeText(
                    context,
                    "update document success.",
                    Toast.LENGTH_LONG,
                ).show()
            }.addOnFailureListener { e ->
                // Handle any errors that occurred during the update
                Toast.makeText(
                    context,
                    "Error updating document: ${e.message}",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }.addOnFailureListener { e ->
            // Handle any errors that occurred during the addition of the document
            Toast.makeText(
                context,
                "Error adding document: ${e.message}",
                Toast.LENGTH_SHORT,
            ).show()
        }
    } catch (e: Exception){
//        withContext(Dispatchers.Main){
//            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
//        }
    }
}
//private fun onRegisterClicked(
//    navController: NavController,
//    auth: FirebaseAuth,
//    email: String?,
//    password: String?,
//    context: Context,
////    launcher: ActivityResultLauncher<Intent>
//) {
//    if (email != null && password != null) {
//        auth.createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
////                    val user = FirebaseAuth.getInstance().currentUser
////                    val uid = user?.uid
////
////////                    addDocumentToFirebase(uid)
////                    val db = FirebaseFirestore.getInstance()
////                    val collectionRef = db.collection("users").document(uid!!)
////                    collectionRef.set(email)
//                    // Add the document to the collection
////                    if (uid != null) {
////                        collectionRef.add(uid)
////                    }
//
//                    navController.navigate("HomePage")
//                } else {
//                    Toast.makeText(
//                        context,
//                        "Authentication failed.",
//                        Toast.LENGTH_SHORT,
//                    ).show()
//                    navController.currentDestination
//                }
//            }
//    } else {
//        Toast.makeText(
//            context,
//            "email and password empty.",
//            Toast.LENGTH_SHORT,
//        ).show()
//        navController.currentDestination
//
//    }
//}
//
//fun addDocumentToFirebase(uid: String?) {
//    val db = FirebaseFirestore.getInstance()
//    val collectionRef = db.collection("users")
//    // Add the document to the collection
//    if (uid != null) {
//        collectionRef.add(uid)
//    }
//}