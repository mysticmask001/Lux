package net.ezra.ui


import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.navigation.ROUTE_HOMES
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.home.HomesScreen


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SplashScreen(navController: NavHostController) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        // Customize the delay time
        delay(3000L)
        navController.navigate(ROUTE_HOMES)
    }

    // Image

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )

        Text("LUX")


        val image = listOf(
            "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
            // add more images to the list
        )

        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {

//            AutoSlidingCarousel(
//                itemsCount = images.size,
//                itemContent = { index ->
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(images[index])
//                            .build(),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.height(200.dp)
//                    )
//                }
//            )
//        }


//            val images = listOf(
//                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
//                // add more images to the list
//            )
//
//            Card(
//                modifier = Modifier.padding(16.dp),
//                shape = RoundedCornerShape(16.dp),
//            ) {
//                HorizontalPager(
//                    beyondBoundsPageCount = images.size,
////                count = images.size,
//                    modifier = Modifier.height(200.dp)
//                ) { page ->
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(images[page])
//                            .build(),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//            }

            

//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = MaterialTheme.colorScheme.background
//                        ) {
//                Scaffold(
//                    bottomBar = {
//                        BottomNavigation {
//                            val navBackStackEntry by navController.currentBackStackEntryAsState()
//                            val currentDestination = navBackStackEntry?.destination
//
//                            BottomNavigationItem(
//                                            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "") },
//                                            label = { Text("Home") },
//                                            selected = currentDestination?.hierarchy?.any { it.route == "home" } == true,
//                                            onClick = {
//                                                navController.navigate("home") {
//                                                    popUpTo("home") {
//                                                        inclusive = true
//                                                    }
//                                                }
//                                            }
//                                        )
//                                        BottomNavigationItem(
//                                            icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "") },
//                                            label = { Text("Settings") },
//                                            selected = currentDestination?.hierarchy?.any { it.route == "settings" } == true,
//                                            onClick = {
//                                                navController.navigate("settings") {
//                                                    popUpTo("settings") {
//                                                        inclusive = true
//                                                    }
//                                                }
//                                            }
//                                        )
//                                    }
//                                }
////                            ) {
//////                    androidx.navigation.Navigation(navController = navController)
//////                    androidx.navigation.Navigation(navController = navController)
////                            }
//                        }
//                    }
//
//
//
//

        }
    }
}

    @Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
    @Composable
    fun HomeScreenPreviewLight() {
        SplashScreen(rememberNavController())
    }


