package net.ezra.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_HOME

import net.ezra.navigation.ROUTE_HOMES
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.ui.services.ServicesScreen
import net.ezra.ui.theme.AppTheme


@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {


                Image(
                    painter = painterResource(
                        id = R.drawable.tom
                    ),
                    contentDescription = "null",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .padding(top = 200.dp)
//
                        .fillMaxSize(),

//            verticalArrangement = Arrangement.Center,

                    horizontalAlignment = Alignment.CenterHorizontally


                ) {
                    Text(
                        text = "WELCOME TO",
                        fontSize = 30.sp,
                        color = Color.White,
                        fontFamily = FontFamily.SansSerif
                    )

                    Text(
                        text = "LUX !",
                        fontSize = 50.sp,
                        color = Color.White,
                        fontFamily = FontFamily.Cursive
                    )

                    Text(
                        text = "Dare to live in luxury",
                        color = Color.White,
//                fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(350.dp))






                    Row {
                        Button(onClick = {},


                            modifier = Modifier


                                .clickable {
                                    navController.navigate(ROUTE_LOGIN) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                }
                        )
                        {

                            Text(text = "Log in")
                        }



                        Spacer(modifier = Modifier.width(10.dp))

                        Button(onClick = {},


                            modifier = Modifier


                                .clickable {
                                    navController.navigate(ROUTE_SIGNUP) {
                                        popUpTo(ROUTE_HOME) { inclusive = true }
                                    }
                                }
                        )
                        {

                            Text(text = "Sign up")


                        }

                    }
                    Spacer(modifier = Modifier.height(70.dp))


                    Button(onClick = {},


                        modifier = Modifier

                            .clickable {
                                navController.navigate(ROUTE_HOMES) {
                                    popUpTo(ROUTE_HOME) { inclusive = true }
                                }
                            }
                    )
                    {

                        Text(text = "Dive in")
                        Spacer(modifier = Modifier.width(15.dp))

                        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
                    }




                }
            }
        }
    }


            

}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    HomeScreen(rememberNavController())
}
