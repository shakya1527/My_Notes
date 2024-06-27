package com.shakya.mynotes.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.ui.screens.AddOrEdit
import com.shakya.mynotes.ui.screens.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object MainScreen

@Serializable
class AddOrEditArgs(
    val title: String= "",
    val description: String="",
    val created: Long = System.currentTimeMillis()
)

fun Note.toAddOrEdit() = AddOrEditArgs(this.title, this.description, this.created)

fun AddOrEditArgs.toNotes() = Note(this.title, this.description, this.created)


@Composable
fun MyNotesNavigation(modifier: Modifier = Modifier, navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen
    ) {
        composable<MainScreen> {
            MainScreen(navHostController = navHostController)
        }
        composable<AddOrEditArgs> {entry->
            val args=entry.toRoute<AddOrEditArgs>().toNotes()
            AddOrEdit(args= args, navHostController = navHostController)
        }
    }
}
