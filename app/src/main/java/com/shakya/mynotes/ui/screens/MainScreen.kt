package com.shakya.mynotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.shakya.mynotes.ui.AddOrEdit
import com.shakya.mynotes.ui.theme.MyNotesTheme
import com.shakya.mynotes.ui.theme.colorList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier, navHostController: NavHostController= rememberNavController()) {
    Scaffold(modifier = modifier, floatingActionButton = { FloatingActionButton(onClick = { navHostController.navigate(AddOrEdit)}) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)

    }
    }, topBar = { TopAppBar(title = { Text(text = "My Notes") }) }) { contentPadding ->
        LazyColumn(contentPadding = contentPadding) {

        }

    }
}

@Composable
fun NotesItem(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorList.random(), contentColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Title", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Date", style = MaterialTheme.typography.labelSmall)
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