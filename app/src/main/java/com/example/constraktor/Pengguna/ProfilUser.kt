package com.example.constraktor.Pengguna

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.example.constraktor.users
import com.google.android.play.core.integrity.e
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun ProfilUser(navController: NavController, uId: String, context: Context) {
//    val db = Firebase.firestore
//    val db = FirebaseFirestore.getInstance()
//    val userId = uId?.getString("uId") ?: ""
//    var nomorhp = bundle?.getString("nomorHp")
    var nama = ""
    var email = ""
    var nomorHp = ""
    val db = FirebaseFirestore.getInstance()
    val usersCollection = db.collection("users")
    val query = usersCollection
        .whereEqualTo("id", uId)
    query.get()
        .addOnSuccessListener { querySnapshot ->
            if (!querySnapshot.isEmpty) {
                val userDocument = querySnapshot.documents[0]
                nama = userDocument.get("nama").toString()
                email = userDocument.get("email").toString()
//                nomorHp = userDocument.data!!["nomor_hp"].toString()
                nomorHp = userDocument.get("nomor_hp").toString()
        } else {
        Toast.makeText(context, "Incorrect Email or Password, please try again", Toast.LENGTH_LONG).show()
    }
        }


//                val userData = users(
//                    userDocument.id,
//                    userDocument.data!!["nomor_hp"].toString(),
//                    userDocument.data!!["password"].toString(),
//                    userDocument.data!!["alamat"].toString(),
//                    userDocument.data!!["provinsi"].toString(),
//                    userDocument.data!!["kota"].toString(),
//                    userDocument.data!!["kecamatan"].toString(),
//                    userDocument.data!!["kelurahan"].toString(),
//                    )

//    penyebab crash
//    try {
//        val usersCollection = db.collection("users").document(uId)
//        usersCollection.get()
//            .addOnSuccessListener { documentSnapshot ->
//                    nomorhp = documentSnapshot.data?.get("nomor_hp") as String
//            }.addOnFailureListener { exception ->
//                // Handle any errors that occurred during the update
//                Toast.makeText(
//                    context,
//                    "Error taking document Snapshot: ${exception.message}",
//                    Toast.LENGTH_SHORT,
//                ).show()
//                // Handle any errors that occurred while fetching the document
//            }
//    } catch (e: Exception){
////        withContext(Dispatchers.Main){
////            Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
//        Toast.makeText(
//            context,
//            "$uId Error taking document Snapshot: ${e.message}",
//            Toast.LENGTH_SHORT,
//        ).show()
////        }
//    }

//    usersCollection.get().addOnSuccessListener { document ->
////        val nama.value = document.data?.get("nama") as String
//        val nomorhp = document.data?.get("nomor_hp") as String
////        email.value = document.data?.get("email") as String
//
//    }

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
                text = "Profil Saya",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
        Row(verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(end = 16.dp, start = 16.dp, top = 16.dp)
                .height(80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.profil),
                contentDescription = null,
                modifier = Modifier
                    .size(68.dp)
            )
            Column (
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .width(240.dp)
                    .padding(start = 8.dp)
            ){
                Text(
                    text = "$nama",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Text(
                    text = "$email",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
                Text(
                    text = "$nomorHp",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
            }
            Image(
                painter = painterResource(R.drawable.editprofil),
                contentDescription = null,
                Modifier.size(20.dp)
                    .clickable { navController.navigate("EditProfil") }
            )
        }
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ){
            Text(text = "Account",
                color = Color.Black)
            Spacer(Modifier.height(12.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.bantuan),
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Bantuan",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.next),
                        contentDescription = null,
                        Modifier.fillMaxHeight()
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.syaratdanketentuan),
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Syarat dan Ketentuan",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.next),
                        contentDescription = null,
                        Modifier.fillMaxHeight()
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.kebijakanprivasi),
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Kebijakan Privasi",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.next),
                        contentDescription = null,
                        Modifier.fillMaxHeight()
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.alamattersimpan),
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Alamat Tersimpan",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.next),
                        contentDescription = null,
                        Modifier.fillMaxHeight()
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.penilaianapp),
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Beri Penilaian Aplikasi Constraktor",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.next),
                        contentDescription = null,
                        Modifier.fillMaxHeight()
                    )
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = null,
                    Modifier.size(24.dp)
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .drawBehind {
                            drawLine(
                                color = Color.LightGray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = androidx.compose.ui.graphics.drawscope.Stroke.DefaultMiter
                            )
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Keluar Akun",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Image(
                        painter = painterResource(R.drawable.next),
                        contentDescription = null,
                        Modifier.fillMaxHeight()
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProfilUser() {
    val navController = rememberNavController()
//    ProfilUser(navController)
}