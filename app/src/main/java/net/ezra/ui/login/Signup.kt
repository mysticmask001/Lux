//package net.ezra.ui.login
//
//import android.content.res.Configuration.UI_MODE_NIGHT_NO
//import androidx.activity.compose.BackHandler
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.google.firebase.auth.FirebaseAuth
//import net.ezra.R
//import net.ezra.navigation.ROUTE_HOME
//import net.ezra.navigation.ROUTE_LOGIN
//import net.ezra.navigation.ROUTE_SIGNUP
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SignupScreen(navController: NavController, onLoginSuccess: () -> Unit) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var error by remember { mutableStateOf<String?>(null) }
//    var isLoading by remember { mutableStateOf(false) }
//
////    BackHandler {
////        navController.popBackStack()
////
////    }
//
//    Column(
//        modifier = Modifier
//            .background(Color.White)
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Image(painter = painterResource(id = R.drawable.steam),
//            contentDescription = "",
//            modifier = Modifier
//                .size(80.dp))
//        Text(text = "Service Teke")
//
//
//        androidx.compose.material.Text("Login", style = MaterialTheme.typography.h4)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        androidx.compose.material.OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { androidx.compose.material.Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//
//        androidx.compose.material.OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { androidx.compose.material.Text("Password") },
//            visualTransformation = PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth()
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        if (isLoading) {
//            androidx.compose.material.CircularProgressIndicator(modifier = Modifier.size(48.dp))
//        } else {
//
//
//            androidx.compose.material.Button(
//                colors = ButtonDefaults.buttonColors(Color(0xff75d6ee)),
//                onClick = {
//                    if (email.isBlank() || password.isBlank()) {
//                        error = "Please fill in all fields"
//                    } else {
//                        isLoading = true
//                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
//                            .addOnCompleteListener { task ->
//                                isLoading = false
//                                if (task.isSuccessful) {
//                                    navController.navigate(ROUTE_HOME)
//                                } else {
//                                    error = task.exception?.message ?: "Sign up failed"
//                                }
//                            }
//                    }
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                androidx.compose.material.Text("Login")
//            }
//
//            androidx.compose.material3.Text(
//                modifier = Modifier
//
//                    .clickable {
//                        navController.navigate(ROUTE_LOGIN) {
//
//
//                            popUpTo(ROUTE_SIGNUP) { inclusive = true }
//                        }
//                    },
//                text = "go to register",
//                textAlign = TextAlign.Center,
//                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
//            )
//
//
//
//        }
//
//        error?.let {
//            androidx.compose.material.Text(
//                text = it,
//                color = MaterialTheme.colors.error,
//                modifier = Modifier.padding(top = 8.dp)
//            )
//        }
//    }
//
//}
//
//
////import android.content.res.Configuration.UI_MODE_NIGHT_NO
////import androidx.compose.foundation.Image
////import androidx.compose.foundation.clickable
////import androidx.compose.foundation.layout.Arrangement
////import androidx.compose.foundation.layout.Box
////import androidx.compose.foundation.layout.Column
////import androidx.compose.foundation.layout.Row
////import androidx.compose.foundation.layout.Spacer
////import androidx.compose.foundation.layout.fillMaxSize
////import androidx.compose.foundation.layout.fillMaxWidth
////import androidx.compose.foundation.layout.height
////import androidx.compose.foundation.layout.padding
////import androidx.compose.foundation.layout.wrapContentSize
////import androidx.compose.foundation.text.KeyboardOptions
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.filled.CheckCircle
////import androidx.compose.material.icons.filled.Email
////import androidx.compose.material.icons.filled.Lock
////import androidx.compose.material.icons.filled.Person
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.layout.ContentScale
////import androidx.compose.ui.res.painterResource
////import androidx.compose.ui.res.stringResource
////import androidx.compose.ui.text.TextStyle
////import androidx.compose.ui.text.input.ImeAction
////import androidx.compose.ui.text.input.KeyboardCapitalization
////import androidx.compose.ui.text.input.KeyboardType
////import androidx.compose.ui.text.input.PasswordVisualTransformation
////import androidx.compose.ui.text.style.TextAlign
////import androidx.compose.ui.tooling.preview.Preview
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////import androidx.constraintlayout.compose.ConstraintLayout
////import androidx.constraintlayout.compose.Dimension
////import androidx.navigation.NavHostController
////import androidx.navigation.compose.rememberNavController
////import com.google.firebase.auth.FirebaseAuth
////import net.ezra.R
////import net.ezra.navigation.ROUTE_CONTACT
////import net.ezra.navigation.ROUTE_HOMES
////import net.ezra.navigation.ROUTE_LOGIN
////import net.ezra.navigation.ROUTE_SIGNUP
////import net.ezra.ui.theme.spacing
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun SignupScreen(navController: NavHostController, onSignupScreen: () -> Unit) {
////
////    Box(
////        modifier = Modifier
////            .fillMaxSize()
////    ) {
////
////
////        Image(
////            painter = painterResource(
////                id = R.drawable.steam
////            ),
////            contentDescription = "null",
////            contentScale = ContentScale.Crop,
////            modifier = Modifier.fillMaxSize()
////        )
////
////        Column(
////            modifier = Modifier
////                .fillMaxSize()
////                .padding(10.dp),
////
////            verticalArrangement = Arrangement.Center,
////
////            horizontalAlignment = Alignment.CenterHorizontally
////
////
////        ) {
////
////            Spacer(modifier = Modifier.height(30.dp))
////
////            var error by remember { mutableStateOf<String?>(null) }
////            var isLoading by remember { mutableStateOf(false) }
////
////            var name by remember { mutableStateOf("") }
////
//////        TextField(value = name, onValueChange = {name = it})
////
////
////            TextField(
////                value = name,
////                onValueChange = { name = it },
////                label = { Text(text = "Enter Name") },
////                leadingIcon = {
////                    Icon(imageVector = Icons.Default.Person, contentDescription = "null")
////                },
////                colors = TextFieldDefaults.outlinedTextFieldColors(
////                    focusedBorderColor = Color.Green,
////                    unfocusedBorderColor = Color.Black,
////                    focusedLabelColor = Color.Green,
////                    unfocusedLabelColor = Color.White,
////                    focusedLeadingIconColor = Color.Green,
////                    unfocusedLeadingIconColor = Color.Black
////                ),
////
////                textStyle = TextStyle(Color.White)
////            )
////
////            Spacer(modifier = Modifier.height(20.dp))
////
////            var email by remember { mutableStateOf("") }
////
//////        TextField(value = name, onValueChange = {name = it})
////
////
////            TextField(
////                value = email,
////                onValueChange = { email = it },
////                label = { Text(text = "Enter Email") },
////                leadingIcon = {
////                    Icon(imageVector = Icons.Default.Email, contentDescription = "null")
////                },
////                colors = TextFieldDefaults.outlinedTextFieldColors(
////                    focusedBorderColor = Color.Green,
////                    unfocusedBorderColor = Color.Black,
////                    focusedLabelColor = Color.Green,
////                    unfocusedLabelColor = Color.White,
////                    focusedLeadingIconColor = Color.Green,
////                    unfocusedLeadingIconColor = Color.Black
////                ),
////
////                textStyle = TextStyle(Color.White)
////            )
////
////            Spacer(modifier = Modifier.height(20.dp))
////
////
////            var password by remember { mutableStateOf("") }
////
//////        TextField(value = name, onValueChange = {name = it})
////
////
////            TextField(
////                value = password,
////                onValueChange = { password = it },
////                label = { Text(text = "Password") },
////                leadingIcon = {
////                    Icon(imageVector = Icons.Default.Lock, contentDescription = "null")
////                },
////                colors = TextFieldDefaults.outlinedTextFieldColors(
////                    focusedBorderColor = Color.Green,
////                    unfocusedBorderColor = Color.Black,
////                    focusedLabelColor = Color.Green,
////                    unfocusedLabelColor = Color.White,
////                    focusedLeadingIconColor = Color.Green,
////                    unfocusedLeadingIconColor = Color.Black
////                ),
////
////                visualTransformation = PasswordVisualTransformation(),
////                keyboardOptions = KeyboardOptions(
////                    capitalization = KeyboardCapitalization.None,
////                    autoCorrect = false,
////                    keyboardType = KeyboardType.Password,
////                    imeAction = ImeAction.Done
////                ),
////
////                textStyle = TextStyle(Color.White)
////            )
////
////            Spacer(modifier = Modifier.height(20.dp))
////
////
////            Text(text = "Already have an account?", color = Color.White)
////            Text(
////                modifier = Modifier
////                    .clickable {
////                        navController.navigate(ROUTE_LOGIN) {
////                            popUpTo(ROUTE_SIGNUP) { inclusive = true }
////                        }
////                    },
////                text = "Click here to login",
////                color = Color.White
////
////
////            )
////
////            Spacer(modifier = Modifier.height(2.dp))
////
////            Button(
////                onClick = {
////
////                    if (email.isBlank() || password.isBlank() || name.isBlank()) {
////                        error = "Please fill in all fields"
////                    } else {
////                        isLoading = true
////                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
////                            .addOnCompleteListener { task ->
////                                isLoading = false
////                                if (task.isSuccessful) {
////                                    navController.navigate(ROUTE_HOMES)
////                                } else {
////                                    error = task.exception?.message ?: "Sign up failed"
////                                }
////                            }
////                    }
////                },
////                modifier = Modifier.fillMaxWidth()
////            ) {
////                androidx.compose.material.Text("Sign up")
////            }
////
////            androidx.compose.material3.Text(
////                modifier = Modifier
////
////                    .clickable {
////                        navController.navigate(ROUTE_LOGIN) {
////                            popUpTo(ROUTE_SIGNUP) { inclusive = true }
////                        }
////                    },
////                text = "Login",
////                textAlign = TextAlign.Center,
////                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
////            )
////
////
////
////
////            error?.let {
////                androidx.compose.material.Text(
////                    text = it,
////                    modifier = Modifier.padding(top = 8.dp)
////                )
////            }
////
////
////        }
////
////
////
////
////
////        }
////
////
////    }
//
//
//
//
//
////    var name by remember { mutableStateOf("") }
////    var email by remember { mutableStateOf("") }
////    var password by remember { mutableStateOf("") }
////
////    ConstraintLayout(
////        modifier = Modifier.fillMaxSize()
////    ) {
////        val (refHeader, refName, refEmail, refPassword, refButtonSignup, refTextSignup) = createRefs()
////        val spacing = MaterialTheme.spacing
////
////        Box(
////            modifier = Modifier
////                .constrainAs(refHeader) {
////                    top.linkTo(parent.top, spacing.extraLarge)
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
////                    width = Dimension.fillToConstraints
////                }
////                .wrapContentSize()
////        ) {
////            AuthHeader()
////        }
////
////        TextField(
////            value = name,
////            onValueChange = {
////                name = it
////            },
////            label = {
////                Text(text = stringResource(id = R.string.name))
////            },
////            modifier = Modifier.constrainAs(refName) {
////                top.linkTo(refHeader.bottom, spacing.extraLarge)
////                start.linkTo(parent.start, spacing.large)
////                end.linkTo(parent.end, spacing.large)
////                width = Dimension.fillToConstraints
////            },
////            keyboardOptions = KeyboardOptions(
////                capitalization = KeyboardCapitalization.None,
////                autoCorrect = false,
////                keyboardType = KeyboardType.Email,
////                imeAction = ImeAction.Next
////            )
////        )
////
////        TextField(
////            value = email,
////            onValueChange = {
////                email = it
////            },
////            label = {
////                Text(text = stringResource(id = R.string.email))
////            },
////            modifier = Modifier.constrainAs(refEmail) {
////                top.linkTo(refName.bottom, spacing.medium)
////                start.linkTo(parent.start, spacing.large)
////                end.linkTo(parent.end, spacing.large)
////                width = Dimension.fillToConstraints
////            },
////            keyboardOptions = KeyboardOptions(
////                capitalization = KeyboardCapitalization.None,
////                autoCorrect = false,
////                keyboardType = KeyboardType.Email,
////                imeAction = ImeAction.Next
////            )
////        )
////
////        TextField(
////            value = password,
////            onValueChange = {
////                password = it
////            },
////            label = {
////                Text(text = stringResource(id = R.string.password))
////            },
////            modifier = Modifier.constrainAs(refPassword) {
////                top.linkTo(refEmail.bottom, spacing.medium)
////                start.linkTo(parent.start, spacing.large)
////                end.linkTo(parent.end, spacing.large)
////                width = Dimension.fillToConstraints
////            },
////            visualTransformation = PasswordVisualTransformation(),
////            keyboardOptions = KeyboardOptions(
////                capitalization = KeyboardCapitalization.None,
////                autoCorrect = false,
////                keyboardType = KeyboardType.Password,
////                imeAction = ImeAction.Done
////            )
////        )
////
////        Button(
////            onClick = {
////
////            },
////            modifier = Modifier.constrainAs(refButtonSignup) {
////                top.linkTo(refPassword.bottom, spacing.large)
////                start.linkTo(parent.start, spacing.extraLarge)
////                end.linkTo(parent.end, spacing.extraLarge)
////                width = Dimension.fillToConstraints
////            }
////        ) {
////            Text(text = stringResource(id = R.string.signup), style = MaterialTheme.typography.titleMedium)
////        }
////
////
////        Text(
////            modifier = Modifier
////                .constrainAs(refTextSignup) {
////                    top.linkTo(refButtonSignup.bottom, spacing.medium)
////                    start.linkTo(parent.start, spacing.extraLarge)
////                    end.linkTo(parent.end, spacing.extraLarge)
////                }
////                .clickable {
////                    navController.navigate(ROUTE_LOGIN) {
////                        popUpTo(ROUTE_SIGNUP) { inclusive = true }
////                    }
////                },
////            text = stringResource(id = R.string.already_have_account),
////            style = MaterialTheme.typography.bodyLarge,
////            textAlign = TextAlign.Center,
////            color = MaterialTheme.colorScheme.onSurface
////        )
////
////    }
//
