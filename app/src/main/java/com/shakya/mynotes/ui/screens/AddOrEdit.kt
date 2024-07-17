package com.shakya.mynotes.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.ui.activity.NoteEvents
import com.shakya.mynotes.ui.theme.MyNotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrEdit(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    args: Note,
    onEvent: (NoteEvents) -> Unit = {},
) {
    val isEdit = args.title.isNotEmpty()
    var title by remember {
        mutableStateOf(args.title)
    }
    var des by remember {
        mutableStateOf(args.description)
    }


    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = if (isEdit) "Edit" else "Add") }, navigationIcon = {
                IconButton(
                    onClick = { navHostController.navigateUp() }, modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }, actions = {
                if (isEdit) {
                    IconButton(onClick = {
                        onEvent.invoke(NoteEvents.DeleteNote(args))
                        navHostController.navigateUp()
                    }) {
                        Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    }
                }
                AnimatedVisibility(visible = title.isNotEmpty() && des.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            onEvent.invoke(
                                NoteEvents.AddOrEditEvent(
                                    Note(
                                        title,
                                        des,
                                        args.created
                                    )
                                )
                            )
                            navHostController.navigateUp()
                        }, modifier = Modifier
                    ) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = null)
                    }
                }
            })
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(8.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Title, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { title = "" }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrectEnabled = true,
                    capitalization = KeyboardCapitalization.Sentences,
                    showKeyboardOnFocus = true,
                    imeAction = androidx.compose.ui.text.input.ImeAction.Next
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = des,
                onValueChange = { des = it },
                label = { Text(text = "Description") },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Description, contentDescription = null)
                },
                trailingIcon = {
                    IconButton(onClick = { des = "" }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    autoCorrectEnabled = true,
                    capitalization = KeyboardCapitalization.Sentences,
                    showKeyboardOnFocus = true,
                    imeAction = androidx.compose.ui.text.input.ImeAction.Done
                )
            )
        }

    }
}

fun save(notes: MutableList<Note>, args: Note, isUpdate: Boolean) {
    if (isUpdate) {
        val index = notes.indexOfFirst { it.created == args.created }
        notes[index] = args
    } else {
        notes.add(args)
    }
}

@Preview
@Composable
private fun AddOrEditPreview() {
    MyNotesTheme {
        AddOrEdit(args = Note(title = "My Notes", description = "Welcome to Android World"))
    }
}