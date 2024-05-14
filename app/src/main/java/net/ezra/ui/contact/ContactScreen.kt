package net.ezra.ui.contact

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_APART
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOMES


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavHostController) {
LazyColumn {
    item {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {


            Image(
                painter = painterResource(
                    id = R.drawable.smoke
                ),
                contentDescription = "null",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),

                verticalArrangement = Arrangement.Center,

                horizontalAlignment = Alignment.CenterHorizontally


            ) {

                Text(
                    text = "NEED A HOME?",
                    color = Color.White,
                    fontSize = 40.sp,

                    modifier = Modifier
                        .padding(20.dp)
                        .padding(10.dp)

                )


//            Text(text = "NEED A HOME?",
//                fontFamily = FontFamily.SansSerif,
//                color = Color.White,
//
//                modifier = Modifier
//                    .size(150.dp)
//            )

                Spacer(modifier = Modifier.height(30.dp))


//                var name by remember { mutableStateOf("") }
//
////        TextField(value = name, onValueChange = {name = it})
//
//
//                TextField(
//                    value = name,
//                    onValueChange = { name = it },
//                    label = { Text(text = "Enter Name") },
//                    leadingIcon = {
//                        Icon(imageVector = Icons.Default.Person, contentDescription = "null")
//                    },
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = Color.Green,
//                        unfocusedBorderColor = Color.Black,
//                        focusedLabelColor = Color.Green,
//                        unfocusedLabelColor = Color.White,
//                        focusedLeadingIconColor = Color.Green,
//                        unfocusedLeadingIconColor = Color.Black
//                    ),
//
//                    textStyle = TextStyle(Color.White)
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//
//                var email by remember { mutableStateOf("") }
//
////        TextField(value = name, onValueChange = {name = it})
//
//
//                TextField(
//                    value = email,
//                    onValueChange = { email = it },
//                    label = { Text(text = "Enter Email") },
//                    leadingIcon = {
//                        Icon(imageVector = Icons.Default.Email, contentDescription = "null")
//                    },
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedBorderColor = Color.Green,
//                        unfocusedBorderColor = Color.Black,
//                        focusedLabelColor = Color.Green,
//                        unfocusedLabelColor = Color.White,
//                        focusedLeadingIconColor = Color.Green,
//                        unfocusedLeadingIconColor = Color.Black
//                    ),
//
//                    textStyle = TextStyle(Color.White)
//                )

                Spacer(modifier = Modifier.height(20.dp))


                var mess by remember { mutableStateOf("") }

//        TextField(value = name, onValueChange = {name = it})


                TextField(
                    value = mess,
                    onValueChange = { mess = it },
                    label = { Text(text = "I am interested....") },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.CheckCircle, contentDescription = "null")
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Green,
                        unfocusedBorderColor = Color.Black,
                        focusedLabelColor = Color.Green,
                        unfocusedLabelColor = Color.White,
                        focusedLeadingIconColor = Color.Green,
                        unfocusedLeadingIconColor = Color.Black
                    ),

                    textStyle = TextStyle(Color.White)
                )

                Spacer(modifier = Modifier.height(20.dp))


                Row {
                    Button(
                        onClick = {
                            navController.navigate(ROUTE_ADD_STUDENTS) {
                                popUpTo(ROUTE_CONTACT) { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = "Make Offer")
                    }

                }

                Spacer(modifier = Modifier.height(2.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_HOMES) {
                        popUpTo(ROUTE_CONTACT) { inclusive = true }
                    }
                }

                )
                {

                    Text(text = "Back")
                }




            }



        }
    }
}



}




@Composable
fun openEmailer() {

    // in the below line, we are
    // creating variables for URL
    val senderEmail = remember {
        mutableStateOf(TextFieldValue())
    }
    val emailSubject = remember {
        mutableStateOf(TextFieldValue())
    }
    val emailBody = remember {
        mutableStateOf(TextFieldValue())
    }
    val ctx = LocalContext.current

    // on below line we are creating
    // a variable for a context


    // on below line we are creating a column
    Column(
        // on below line we are specifying modifier
        // and setting max height and max width
        // for our column
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            // on below line we are
            // adding padding for our column
            .padding(5.dp),
        // on below line we are specifying horizontal
        // and vertical alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

//        // on the below line, we are
//        // creating a text field.
//        TextField(
//            // on below line we are specifying
//            // value for our  text field.
//            value = senderEmail.value,
//
//            // on below line we are adding on value
//            // change for text field.
//            onValueChange = { senderEmail.value = it },
//
//            // on below line we are adding place holder as text
//            placeholder = { Text(text = "Enter sender email address") },
//
//            // on below line we are adding modifier to it
//            // and adding padding to it and filling max width
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//
//            // on below line we are adding text style
//            // specifying color and font size to it.
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//
//            // on below line we are
//            // adding single line to it.
//            singleLine = true,
//        )
//        // on below line adding a spacer.
//        Spacer(modifier = Modifier.height(10.dp))
//
//        // on the below line, we are creating a text field.
//        TextField(
//            // on below line we are specifying
//            // value for our  text field.
//            value = emailSubject.value,
//
//            // on below line we are adding on value change
//            // for text field.
//            onValueChange = { emailSubject.value = it },
//
//            // on below line we are adding place holder as text
//            placeholder = { Text(text = "Enter email subject") },
//
//            // on below line we are adding modifier to it
//            // and adding padding to it and filling max width
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//
//            // on below line we are adding text style
//            // specifying color and font size to it.
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//
//            // on below line we are
//            // adding single line to it.
//            singleLine = true,
//        )
//
//        // on below line adding a spacer.
//        Spacer(modifier = Modifier.height(10.dp))
//
//        // on the below line, we are creating a text field.
//        TextField(
//            // on below line we are specifying
//            // value for our  text field.
//            value = emailBody.value,
//
//            // on below line we are adding on value
//            // change for text field.
//            onValueChange = { emailBody.value = it },
//
//            // on below line we are adding place holder as text
//            placeholder = { Text(text = "Enter email body") },
//
//            // on below line we are adding modifier to it
//            // and adding padding to it and filling max width
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//
//            // on below line we are adding text style
//            // specifying color and font size to it.
//            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
//
//            // on below line we are
//            // adding single line to it.
//            singleLine = true,
//        )
//
//        // on below line adding a spacer.
//        Spacer(modifier = Modifier.height(20.dp))
//
//        // on below line adding a
//        // button to send an email
        Button(onClick = {

            // on below line we are creating
            // an intent to send an email
            val i = Intent(Intent.ACTION_SEND)

            // on below line we are passing email address,
            // email subject and email body
            val emailAddress = arrayOf(senderEmail.value.text)
            i.putExtra(Intent.EXTRA_EMAIL,emailAddress)
            i.putExtra(Intent.EXTRA_SUBJECT,emailSubject.value.text)
            i.putExtra(Intent.EXTRA_TEXT,emailBody.value.text)

            // on below line we are
            // setting type of intent
            i.setType("message/rfc822")

            // on the below line we are starting our activity to open email application.
            ctx.startActivity(Intent.createChooser(i,"Choose an Email client : "))

        }) {
            // on the below line creating a text for our button.
            Text(
                // on below line adding a text ,
                // padding, color and font size.
                text = "Make Offer",
                modifier = Modifier
                    .padding(10.dp),

                color = Color.White,
                fontSize = 15.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    ContactScreen(rememberNavController())
}

