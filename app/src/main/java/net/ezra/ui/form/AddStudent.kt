@file:Suppress("NAME_SHADOWING")
package net.ezra.ui.form

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_HOMES
import java.util.UUID


var progressDialog: ProgressDialog? = null
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudents(navController: NavHostController) {
    val context = LocalContext.current


    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Personal info")
                },
                navigationIcon = {
                    IconButton(onClick = {


                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                        }


                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon", tint = Color.White)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,

                    )
            )
        }, content = {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {


                Image(
                    painter = painterResource(
                        id = R.drawable.spongebob
                    ),
                    contentDescription = "null",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
            ) {
                LazyColumn {
                    item {
                        Column(







                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                            Card (


                            ){

                            }

                            Spacer(modifier = Modifier.height(10.dp))


                            var photoUri: Uri? by remember { mutableStateOf(null) }
                            val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                                photoUri = uri
                            }

                            var Name by rememberSaveable {
                                mutableStateOf("")
                            }


                            var Email by rememberSaveable {
                                mutableStateOf("")
                            }

                            var location by rememberSaveable {
                                mutableStateOf("")
                            }

                            var phone by rememberSaveable {
                                mutableStateOf("")
                            }



                            OutlinedTextField(
                                value = Name,
                                onValueChange = { Name = it },
                                label = { Text(text = "Name") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = phone,
                                onValueChange = { phone = it },
                                label = { Text(text = "Phone") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = location,
                                onValueChange = { location = it },
                                label = { Text(text = "Location") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = Email,
                                onValueChange = {Email = it },
                                label = { Text(text = "Email") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )






                            if (photoUri != null) {
                                //Use Coil to display the selected image
                                val painter = rememberAsyncImagePainter(
                                    ImageRequest
                                        .Builder(LocalContext.current)
                                        .data(data = photoUri)
                                        .build()
                                )

                                Image(
                                    painter = painter,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(150.dp)
                                        .height(150.dp)
                                        .border(1.dp, Color.Gray),
                                    contentScale = ContentScale.Crop,

                                    )
                            } else {

                                OutlinedButton(
                                    onClick = {
                                        launcher.launch(
                                            PickVisualMediaRequest(
                                                //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                                //Or use .VideoOnly if you only want videos.
                                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                            )
                                        )
                                    }
                                ) {
                                    Text(text = "Select Image")
                                }
                            }


                            OutlinedButton(onClick = {
//                                var error by remember { mutableStateOf<String?>(null) }
//
//                                var isLoading by remember { mutableStateOf(false) }
//                                if (Email.isBlank() || Name.isBlank()  || location.isBlank()  || phone.isBlank()) {
//                        error = "Please fill in all fields"
//                    } else {
//                        isLoading = true
//                        FirebaseAuth.getInstance().signInWithEmailAndPassword(Email, Name)
//                            .addOnCompleteListener { task ->
//                                isLoading = false
//                                if (task.isSuccessful) {
//                                    navController.navigate(ROUTE_HOMES)
//                                } else {
//                                    error = task.exception?.message ?: "Login failed"
//                                }
//                            }
//                    }
//
//                                error?.let {
//                                    androidx.compose.material.Text(
//                                        text = it,
//                                        color = MaterialTheme.colors.error,
//                                        modifier = Modifier.padding(top = 8.dp)
//                                    )
//                                }
//

//                                if (photoUri != null) {
//
//                                    progressDialog = ProgressDialog(context)
//                                    progressDialog?.setMessage("Uploading data...")
//                                    progressDialog?.setCancelable(false)
//                                    progressDialog?.show()
//
//                                    photoUri?.let {
//
//                                        uploadImageToFirebaseStorage(
//                                            it,
//                                           Name,
//                                            Email,
//                                            location,
//                                            phone,
//                                            context.toString()
//                                        )
//
//
//                                       Name = ""
//
//                                        Email = ""
//                                        location = ""
//                                        phone = ""
//                                        photoUri = null
//
//                                    }
//                                }
//                                else if (Email == ""){
//                                    Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
//                                }
//                                else if(Name == ""){
//                                    Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show()
//                                }
//
//                                else {
//                                    Toast.makeText(context, "Please select an image", Toast.LENGTH_SHORT).show()
//                                }



                            }) {

                                Text(text = "Upload")


                            }


                            Button(onClick = {
                                navController.navigate(ROUTE_HOMES) {
                                    popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                                }
                            }

                            )
                            {

                                Text(text = "Home")
                            }











                        }
                    }
                }
            }

        }}
    )



}

fun uploadImageToFirebaseStorage(imageUri: Uri, studentName: String, studentClass: String, studentEmail: String, location: String, phone: String) {

}


fun uploadImageToFirebaseStorage(
    imageUri: Uri,
    studentName: String,
    studentClass: String,
    studentEmail: String,
    location: String,
    phone: String,
    context: Context

) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(
                downloadUri.toString(),
                studentName,
                studentClass,
                studentEmail,
                location,
                phone,
                context

            
                )

        } else {

            progressDialog?.dismiss()

            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to upload image: ${task.exception?.message}")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked


                }
                .show()


        }
    }
}


fun saveToFirestore(

imageUrl: String,
    Name: String,
    Email: String,
    location: String,
    phone: String,
    phone1: String,
    context: Context,



    ) {

//    var firebaseConfig = {
//        val apiKey = Unit
//        apiKey: "YOUR_API_KEY",
//        authDomain: "YOUR_AUTH_DOMAIN",
//        projectId: "YOUR_PROJECT_ID",
//        storageBucket: "YOUR_STORAGE_BUCKET",
//        messagingSenderId: "YOUR_MESSAGING_SENDER_ID",
//        val appId = null
//        appId: "YOUR_APP_ID"
//    };
//
//    firebase.initializeApp(firebaseConfig);


    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "Name" to Name,
        "Email" to Email,
        "location" to location,
        "phone" to phone


    )


    db.collection("Info")
        .add(imageInfo)
        .addOnSuccessListener { documentReference ->

            progressDialog?.dismiss()

            // Show success dialog
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setTitle("Success")
                .setMessage("Data saved successfully!")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked
                }
                .setIcon(R.drawable.splash)
                .setCancelable(true)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            // Customize the dialog style (optional)
            val alertDialogStyle = alertDialog.window?.attributes
            alertDialog.window?.attributes = alertDialogStyle
        }
        .addOnFailureListener {

            progressDialog?.dismiss()


            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to save data")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked


                }
                .show()


        }

}






@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    AddStudents(rememberNavController())
}



