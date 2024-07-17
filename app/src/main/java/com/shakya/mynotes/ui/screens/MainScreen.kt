package com.shakya.mynotes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.BrightnessAuto
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.DeleteSweep
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.db.toFormattedDate
import com.shakya.mynotes.ui.AddOrEditArgs
import com.shakya.mynotes.ui.activity.NoteEvents
import com.shakya.mynotes.ui.theme.MyNotesTheme
import com.shakya.mynotes.ui.theme.colorList
import com.shakya.mynotes.ui.toAddOrEdit
import com.shakya.mynotes.utils.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    notes: List<Note> = listOf(),
    theme: Theme = Theme.AUTO,
    onEvent: (NoteEvents) -> Unit = {}
) {
    var isDialogVisible by remember { mutableStateOf(false) }
    if (isDialogVisible) {
        AlertDialog(onDismissRequest = { isDialogVisible = false },
            confirmButton = { onEvent.invoke(NoteEvents.DeleteAll) },
            icon = { Icon(imageVector = Icons.Default.Warning, contentDescription = null) },
            title = { Text(text = "Delete All") },
            text = { Text(text = "Are you sure you want to delete all notes?") })
    }
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(onClick = { navHostController.navigate(AddOrEditArgs()) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "My Notes") },
                actions = {
                        IconButton(onClick = {
                            val nextTheme = when(theme){
                                Theme.AUTO -> Theme.LIGHT
                                Theme.LIGHT -> Theme.DARK
                                Theme.DARK -> Theme.AUTO
                            }
                            onEvent.invoke(NoteEvents.OnThemeChange(nextTheme))
                        }) {
                                Icon(imageVector =when(theme){
                                    Theme.AUTO -> Icons.Default.BrightnessAuto
                                    Theme.LIGHT -> Icons.Default.LightMode
                                    Theme.DARK -> Icons.Default.DarkMode
                                }, contentDescription =null )
                            }
                    if (notes.isNotEmpty())
                        IconButton(onClick = { isDialogVisible = true }) {
                            Icon(imageVector = Icons.Default.DeleteSweep, contentDescription = null)
                        }
                }
            )
        }
    ) { contentPadding ->
        if (notes.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.4f),
                    imageVector = Icons.Default.Dashboard,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "No Notes", style = MaterialTheme.typography.titleLarge)
            }
        }

        LazyColumn(
            contentPadding = contentPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(notes) {
                NotesItem(note = it, onClick = {
                    navHostController.navigate(it.toAddOrEdit())
                })
            }
        }

    }
}

@Composable
fun NotesItem(modifier: Modifier = Modifier, note: Note, onClick: () -> Unit = {}) {
    Card(modifier = modifier
        .fillMaxWidth()
        .clickable { onClick.invoke() }
        .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorList.random(), contentColor = Color.White)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = note.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = note.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = note.created.toFormattedDate(), style = MaterialTheme.typography.labelSmall)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

//@Composable
//fun BottomAppBar(modifier: Modifier = Modifier) {
//    Row(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colorScheme.background)
//            .padding(8.dp)
//    ) {
//        TextField(value = "", onValueChange = {}, label = { Text(text = "Enter a Note") },
//            modifier = Modifier
//                .weight(0.8f)
//                .fillMaxWidth()
//        )
//        IconButton(
//            onClick = { /*TODO*/ }, modifier = Modifier
//                .weight(0.2f)
//                .fillMaxWidth()
//        ) {
//            Icon(imageVector = Icons.AutoMirrored.Default.Send, contentDescription = null)
//        }
//    }
//}

@Preview
@Composable
private fun MainScreenPreview() {
    MyNotesTheme {
        MainScreen()
        //NotesItem()
        // BottomAppBar()
    }
}