package com.example.constraktor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.constraktor.Mitra.BuatNota
import com.example.constraktor.Mitra.DetailPesanan
import com.example.constraktor.Mitra.EditProfilMitra
import com.example.constraktor.Mitra.HomePageMitra
import com.example.constraktor.Mitra.PesananMitra
import com.example.constraktor.Mitra.ProsesPengerjaan
import com.example.constraktor.Pengguna.Bill
import com.example.constraktor.Pengguna.Desain
import com.example.constraktor.Pengguna.EditProfil
import com.example.constraktor.Pengguna.FormAlamat
import com.example.constraktor.Pengguna.FormulirPemesanan
import com.example.constraktor.Pengguna.HomePage
import com.example.constraktor.Pengguna.LihatMitra
import com.example.constraktor.Pengguna.Order
import com.example.constraktor.Pengguna.Pembangunan
import com.example.constraktor.Pengguna.Perbaikan
import com.example.constraktor.Pengguna.PesanPage
import com.example.constraktor.Pengguna.PesananPage
import com.example.constraktor.Pengguna.PilihTukang
import com.example.constraktor.Pengguna.ProfilMitra
import com.example.constraktor.Pengguna.ProfilUser
import com.example.constraktor.ui.theme.ConstraktorTheme
import com.example.constraktor.ui.theme.WhiteConnect
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class profilUser(val foto : Int, val nama : String, val review : String)
val user = arrayOf(
    profilUser(R.drawable.profillight, "Jason Siangeng", "Hasil kerjanya sangat memuaskan, tukangnya jga ramah, sangat saya rekomendasikan."),
    profilUser(R.drawable.profillight, "Jason Siangeng", "Hasil kerjanya sangat memuaskan, tukangnya jga ramah, sangat saya rekomendasikan."),
    profilUser(R.drawable.profillight, "Jason Siangeng", "Hasil kerjanya sangat memuaskan, tukangnya jga ramah, sangat saya rekomendasikan."),
    profilUser(R.drawable.profillight, "Jason Siangeng", "Hasil kerjanya sangat memuaskan, tukangnya jga ramah, sangat saya rekomendasikan."),
    profilUser(R.drawable.profillight, "Jason Siangeng", "Hasil kerjanya sangat memuaskan, tukangnya jga ramah, sangat saya rekomendasikan.")
)

data class users(
    val id: String,
    val nama: String,
    val email: String,
    val nomorhp: String,
    val password: String,
    val alamat: String,
    val provinsi: String,
    val kota: String,
    val kecamatan: String,
    val kelurahan: String
)


data class profilMitra(val foto : Int, val nama : String, val job : String)
val mitra = arrayOf(
    profilMitra(R.drawable.profil, "Ferdinand Jonathan", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Mirza Ababie", "renovasi dan pembangunan" ),
    profilMitra(R.drawable.profil, "Rhema Granaldi", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Michael Ko", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Anneke Anggala", "Desain" ),
    profilMitra(R.drawable.profil, "Ferdinand Jonathan", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Mirza Ababie", "renovasi dan pembangunan" ),
    profilMitra(R.drawable.profil, "Rhema Granaldi", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Michael Ko", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Anneke Anggala", "Desain" ),
    profilMitra(R.drawable.profil, "Ferdinand Jonathan", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Mirza Ababie", "renovasi dan pembangunan" ),
    profilMitra(R.drawable.profil, "Rhema Granaldi", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Michael Ko", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Anneke Anggala", "Desain" ),
    profilMitra(R.drawable.profil, "Ferdinand Jonathan", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Mirza Ababie", "renovasi dan pembangunan" ),
    profilMitra(R.drawable.profil, "Rhema Granaldi", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Michael Ko", "Perbaikan dan Instalasi" ),
    profilMitra(R.drawable.profil, "Anneke Anggala", "Desain" ),
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraktorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = WhiteConnect
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "PilihRole"
                            ){
//                        Login
                        composable("PilihRole") { PilihRole(navController) }
                        composable("PreLogin") { PreLogin(navController) }
                        composable("HalamanMasuk") { HalamanLogin(navController, applicationContext) }
                        composable("HalamanDaftar") { HalamanRegister(navController, applicationContext) }

//                        User
                        composable("HomePage/{uId}"
                        ) { backStackEntry ->
                            val arguments = backStackEntry.arguments
//                            val bundle = arguments?.getBundle("key")
                            val uId = arguments?.getString("uId") ?: ""
                            HomePage(navController, uId) }
                        composable("PesananPage") { PesananPage(navController) }
                        composable("PesanPage") { PesanPage(navController) }
                        composable("ProfilUser/{uId}"
                        ) { backStackEntry ->
                            val arguments = backStackEntry.arguments
//                            val bundle = arguments?.getBundle("key")
                            val uId = arguments?.getString("uId") ?: ""
                            ProfilUser(navController, uId, applicationContext) }
                        composable("EditProfil") { backStackEntry ->
                            val arguments = backStackEntry.arguments
//                            val uId = arguments?.getString("uId") ?: ""
                            EditProfil(navController, arguments) }
                        composable("Perbaikan") { Perbaikan(navController) }
                        composable("Pembangunan") { Pembangunan(navController) }
                        composable("Desain") { Desain(navController) }
                        composable("PembangunanDinding") { PilihTukang(navController, "Pembangunan Dinding") }
                        composable("PembangunanStruktur") { PilihTukang(navController, "Pembangunan Struktur") }
                        composable("PemasanganLantai") { PilihTukang(navController, "Pemasangan Lantai") }
                        composable("PembuatanKanopi") { PilihTukang(navController, "Pembuatan Kanopi") }
                        composable("Kamar") { PilihTukang(navController, "Kamar") }
                        composable("KamarMandi") { PilihTukang(navController, "Kamar Mandi") }
                        composable("BangunRumah") { PilihTukang(navController, "Bangun Rumah") }
                        composable("Eksterior") { PilihTukang(navController, "Eksterior") }
                        composable("Arsitektur") { PilihTukang(navController, "Desain Arsitektur") }
                        composable("Interior") { PilihTukang(navController, "Desain Interior") }
                        composable("LihatMitra") { LihatMitra(navController) }
                        composable("FormulirPemesanan") { FormulirPemesanan(navController) }
                        composable("FormAlamat") { FormAlamat(navController) }
                        composable("Order") { Order(navController) }
                        composable("Bill") { Bill(navController) }

//                        Mitra
                        composable("HomePageMitra") { HomePageMitra(navController) }
                        composable("ProfilMitra") { ProfilMitra(navController) }
                        composable("EditProfilMitra") { EditProfilMitra(navController) }
                        composable("PesananMitra") { PesananMitra(navController) }
                        composable("DetailPesanan") { DetailPesanan(navController) }
                        composable("ProsesPengerjaan") { ProsesPengerjaan(navController) }
                        composable("BuatNota") { BuatNota(navController) }
                    }
                }
            }
        }
    }
}