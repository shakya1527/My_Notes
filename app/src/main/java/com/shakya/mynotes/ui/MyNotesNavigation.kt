package com.shakya.mynotes.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.ui.activity.main.NoteEvents
import com.shakya.mynotes.ui.screens.AddOrEdit
import com.shakya.mynotes.ui.screens.MainScreen
import com.shakya.mynotes.utils.Theme
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
fun MyNotesNavigation(
    navHostController: NavHostController,
    theme: Theme = Theme.AUTO,
    notes: List<Note>,
    onEvent : (NoteEvents) -> Unit = {},
) {
    NavHost(
        navController = navHostController,
        startDestination = MainScreen
    ) {
        composable<MainScreen> {
            MainScreen(
                navHostController = navHostController,
                notes = notes,
                onEvent = onEvent,
                theme = theme
            )
        }
        composable<AddOrEditArgs> {entry->
            val args=entry.toRoute<AddOrEditArgs>().toNotes()
            AddOrEdit(args= args, navHostController = navHostController, onEvent = onEvent)
        }
    }
}
