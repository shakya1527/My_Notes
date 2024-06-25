package com.shakya.mynotes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shakya.mynotes.ui.screens.AddOrEdit
import com.shakya.mynotes.ui.screens.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
object  AddOrEdit

@Composable
fun MyNotesNavigation(modifier: Modifier = Modifier, navHostController: NavHostController) {
   NavHost(
       navController = navHostController,
       startDestination = MainScreen
   ){
       composable<MainScreen> {
           MainScreen(navHostController = navHostController)
       }
       composable<AddOrEdit> {
           AddOrEdit(navHostController = navHostController)
       }
   }
}
