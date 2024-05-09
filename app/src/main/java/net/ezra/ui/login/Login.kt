package net.ezra.ui.login

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOMES
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Image(
            painter = painterResource(
                id = R.drawable.minion
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

            Spacer(modifier = Modifier.height(30.dp))


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
                    unfocusedLeadingIconColor = Color.White
                ),

                textStyle = TextStyle(Color.White)
            )

            Spacer(modifier = Modifier.height(20.dp))


            var password by remember { mutableStateOf("") }

//        TextField(value = name, onValueChange = {name = it})


            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "null")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Green,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Green,
                    unfocusedLabelColor = Color.White,
                    focusedLeadingIconColor = Color.Green,
                    unfocusedLeadingIconColor = Color.White
                ),

                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.None,
                    autoCorrect = false,
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),

                textStyle = TextStyle(Color.White)
            )

            Spacer(modifier = Modifier.height(20.dp))


            Text(text = "Do not have an account?", color = Color.White)


            Spacer(modifier = Modifier.height(2.dp))

            Button(
                    onClick = {
                        navController.navigate(ROUTE_HOMES) {
                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                        }
                    },


                ) {
                    Text(text = "Login")
                }

          


        }


    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun LoginScreenPreviewLight() {
    LoginScreen(rememberNavController())
}

