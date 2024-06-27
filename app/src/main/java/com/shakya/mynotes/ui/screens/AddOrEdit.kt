package com.shakya.mynotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.ui.theme.MyNotesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrEdit(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    notes: List<Note> = listOf(),
    args: Note
) {
    var title by remember {
        mutableStateOf(args.title)
    }
    var des by remember {
        mutableStateOf(args.description)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = "Add or Edit") }, navigationIcon = {
                IconButton(
                    onClick = { navHostController.navigateUp() }, modifier = Modifier
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null
                    )
                }
            }, actions = {
                IconButton(
                    onClick = { /*TODO*/ }, modifier = Modifier
                ) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = null)
                }
            })
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(8.dp)
        ) {
            TextField(value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") },
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = des,
                onValueChange = { des = it },
                label = { Text(text = "Description") },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

    }
}

@Preview
@Composable
private fun AddOrEditPreview() {
    MyNotesTheme {
        AddOrEdit(args = Note(title = "My Notes", description = "Welcome to Android World"))
    }
}