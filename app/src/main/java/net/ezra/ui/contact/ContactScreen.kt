package net.ezra.ui.contact

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_APART
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOMES


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavHostController) {
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


            var name by remember { mutableStateOf("") }

//        TextField(value = name, onValueChange = {name = it})


            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "Enter Name") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "null")
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

            var email by remember { mutableStateOf("") }

//        TextField(value = name, onValueChange = {name = it})


            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter Email") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "null")
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
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = "Make Offer")
                }

            }

            Spacer(modifier = Modifier.height(2.dp))

            Button(onClick = {},


                modifier = Modifier

                    .clickable {
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


@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    ContactScreen(rememberNavController())
}

