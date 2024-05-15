package net.ezra.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.villa.VillaScreen
import net.ezra.ui.apartments.ApartScreen
import net.ezra.ui.apartments.HomeScreenPreviewLight
import net.ezra.ui.bungalows.BungalowScreen
import net.ezra.ui.contact.ContactScreen
import net.ezra.ui.form.AddStudents
import net.ezra.ui.home.HomeScreen
import net.ezra.ui.home.HomesScreen
//import net.ezra.ui.login.LoginScreen
//import net.ezra.ui.login.SignupScreen
import net.ezra.ui.ranch.RanchScreen
import net.ezra.ui.mit.MitScreen

import net.ezra.ui.services.ServicesScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_HOME


) {
    BackHandler {
        navController.popBackStack()

        }
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {




        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }


        composable(ROUTE_HOMES) {
            HomesScreen(navController)
        }


        composable(ROUTE_VILLA) {
            VillaScreen(navController)
        }

        composable(ROUTE_SERVICES) {
            ServicesScreen(navController)
        }

        composable(ROUTE_MIT) {
            MitScreen(navController)
        }

        composable(ROUTE_BUNGALOW) {
            BungalowScreen(navController)
        }

        composable(ROUTE_APART) {
            ApartScreen(navController)
        }

        composable(ROUTE_CONTACT) {
            ContactScreen(navController)
        }

        composable(ROUTE_RANCH) {
            RanchScreen(navController)
        }

        composable(ROUTE_ADD_STUDENTS) {
            AddStudents(navController)
        }































    }
}