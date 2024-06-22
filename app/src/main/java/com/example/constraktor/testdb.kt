package com.example.constraktor

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

data class Item(val id: String, val email: String, val nama: String, val hp: String)

class FirebaseViewModel : ViewModel() {
    private val itemsCollectionRef = Firebase.firestore.collection("items")
    private val _items = mutableStateListOf<Item>()
    val items: List<Item> get() = _items

    init {
        fetchItems()
    }

    fun fetchItems() {
        itemsCollectionRef.get()
            .addOnSuccessListener { snapshot ->
                _items.clear()
                snapshot.documents.forEach { document ->
                    val id = document.id
                    val email = document.getString("email") ?:""
                    val nama = document.getString("nama") ?: ""
                    val hp = document.getString("nomorhp") ?: ""
                    val item = Item(id, email, nama, hp)
                    _items.add(item)
                }
            }
    }
}

private fun onLoginClicked(nomorhp: String, password: String) {
    // Replace this with your actual login logic

    if (nomorhp == nomorhp && password == "password") {
        // Login successful, navigate to the next screen or perform necessary actions
        // For example, you can use Navigation Component to navigate to another destination:
        // NavHostController(context).navigate("destination")
    } else {
        // Login failed, show an error message
//        errorMessage = "Invalid credentials. Please try again."
    }
}
//@Composable
//fun FirebaseScreen(firebaseViewModel: FirebaseViewModel = viewModel()) {
//    val items: List<Item> by firebaseViewModel.items.observeAsState(emptyList())
//
//    // Render the fetched items
//    // ...
//}

//@Composable
//fun App() {
//    val firebaseViewModel: FirebaseViewModel = viewModel()
//    FirebaseScreen(firebaseViewModel)
//}
//
//@Composable
//fun MyApp() {
//    CompositionLocalProvider(LocalContext provides applicationContext) {
//        App()
//    }
//}
