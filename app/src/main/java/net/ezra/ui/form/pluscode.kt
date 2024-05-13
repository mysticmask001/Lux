package net.ezra.ui.form

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


data class Student(

    val imageUrl: String? = "",
    val name: String? = "",
    val phone: String? = "",
    val location: String? = ""


)


class FirestoreViewModel : ViewModel() {

    private val firestore = Firebase.firestore
    private val itemsCollection = firestore.collection("Students")

    private val _items = MutableLiveData<List<Student>>()
    val items: LiveData<List<Student>> = _items

    init {
        fetchItems()
    }

    fun fetchItems() {
        itemsCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                Log.e("FirestoreViewModel", "Error fetching students", error)
                return@addSnapshotListener
            }

            val itemList = mutableListOf<Student>()
            snapshot?.documents?.forEach { document ->
                val item = document.toObject(Student::class.java)
                item?.let {
                    itemList.add(it)
                }
            }
            _items.value = itemList
        }
    }
}

//
//LazyVerticalGrid(
//columns = GridCells.Fixed(1),
//modifier = Modifier
//.padding(10.dp),
//horizontalArrangement = Arrangement.Center
//) {
//
//    items.forEach { item ->
//        item {
//            Column (
//                horizontalAlignment = Alignment.CenterHorizontally
//            ){
//
//                SubcomposeAsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(item.imageUrl)
//                        .crossfade(true)
//                        .build(),
//                    loading = {
//                        CircularProgressIndicator()
//                    },
//                    contentDescription = item.studentName,
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(10))
//                        .size(150.dp)
//
//                )
//
//                item.Name?.let { Text(text = it) }
//                item.phone?.let { Text(text = it) }
//
//
//
//            }
//
//        }


        @SuppressLint("ResourceAsColor")
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun Students(navController: NavHostController, viewModel: FirestoreViewModel) {
            val items by viewModel.items.observeAsState(initial = emptyList())

            // Fetch items when the composable is first created
            LaunchedEffect(viewModel) {
                viewModel.fetchItems()
            }}

