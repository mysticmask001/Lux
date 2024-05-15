package net.ezra.ui.bungalows


import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_APART
import net.ezra.navigation.ROUTE_BUNGALOW
import net.ezra.navigation.ROUTE_CONTACT

import net.ezra.navigation.ROUTE_HOMES
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_RANCH
import net.ezra.navigation.ROUTE_VILLA


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BungalowScreen(navController: NavHostController) {


     Scaffold(
    content = {

        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {


                    Image(
                        painter = painterResource(
                            id = R.drawable.bg
                        ),
                        contentDescription = "null",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Column(
                        modifier = Modifier

                            .wrapContentHeight()
//
                            .fillMaxSize()


                    ) {

                        Row {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "")

                            Spacer(modifier = Modifier.width(150.dp))

                            Text(
                                text = "BUNGALOW",
                                modifier = Modifier
                                    .fillMaxSize()
                            )

                            Spacer(modifier = Modifier.width(150.dp))

                            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "")
                        }
                        LazyRow {
                            item {

                                Text(
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate(ROUTE_HOMES) {
                                                popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                            }
                                        },
                                    text = "Houses(100)"
                                )



                                Spacer(modifier = Modifier.width(30.dp))

                                Text(
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate(ROUTE_APART) {
                                                popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                            }
                                        },
                                    text = "Apartments(404)"
                                )


                                Spacer(modifier = Modifier.width(30.dp))

                                Text(
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate(ROUTE_VILLA) {
                                                popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                            }
                                        },
                                    text = "Villa(305)"
                                )

                                Spacer(modifier = Modifier.width(30.dp))

                                Text(
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate(ROUTE_BUNGALOW) {
                                                popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                            }
                                        },
                                    text = "Bungalows(200)"
                                )



                                Spacer(modifier = Modifier.width(30.dp))

                                Text(
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate(ROUTE_RANCH) {
                                                popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                            }
                                        },
                                    text = "Ranch-Style(60)"
                                )

                            }
                        }


                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Card(
                            elevation = CardDefaults.cardElevation(10.dp),
                            modifier = Modifier
                                .background(color = Color.DarkGray)
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.ck),
                                contentDescription = "null"
//                            imageslider = findViewById(R.drawable.)
//
//
//                            ArrayList<slideModel> Images = new ArrayList<>()
//
//                            images(add new slide)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "WaterMark", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "KAREN", color = Color.White)
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(5.dp)
                            ) {
                                Text(text = "KSH 100.00 PSF", color = Color.White)

                                Spacer(modifier = Modifier.width(250.dp))

                                Text(text = "", color = Color.White, fontFamily = FontFamily.Monospace)

                            }




                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(color = Color.DarkGray)
                                    .padding(10.dp)
                            ) {
                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Home, contentDescription = "null")
//                                Image(painter = painterResource(id = R.drawable.bed), contentDescription ="")

//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Beds")
                                }

                                Spacer(modifier = Modifier.width(20.dp))

                                Button(onClick = {}) {
//                                Icon(
//                                    imageVector = Icons.Default.Person,
//                                    contentDescription = "null"
//                                )
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "3 Baths")
                                }

                                Spacer(modifier = Modifier.width(20.dp))


                                Button(onClick = {}) {
//                                Icon(imageVector = Icons.Default.Check, contentDescription = "null")
//
//                                Spacer(modifier = Modifier.width(2.dp))

                                    Text(text = "2 Cams")
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(1.dp)
                            )


                            Row {

                                Button(onClick = {
                                    navController.navigate(ROUTE_CONTACT) {
                                        popUpTo(ROUTE_BUNGALOW) { inclusive = true }
                                    }
                                },


                                    modifier = Modifier

                                        .fillMaxSize()
                                        .background(color = Color.DarkGray)

                                )
                                {

                                    Text(text = "Talk to us")
                                }

                            }





                        }

                        Spacer(modifier = Modifier.height(5.dp))

                    }


                }
            }

        }

    },

         bottomBar = {BottomBar(navController)}
)



}



@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp,
        backgroundColor = Color.LightGray) {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") }, selected = (selectedIndex.value == 0), onClick = {
                navController.navigate(ROUTE_HOMES) {
                    popUpTo(ROUTE_HOMES) { inclusive = true }
                }})

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Phone,"")
        },
            label = { Text(text = "Contact") }, selected = (selectedIndex.value == 1), onClick = {
                navController.navigate(ROUTE_ADD_STUDENTS) {
                    popUpTo(ROUTE_HOMES) { inclusive = true }
                }})
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
   BungalowScreen(rememberNavController())
}

