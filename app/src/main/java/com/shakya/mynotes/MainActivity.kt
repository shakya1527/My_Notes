package com.shakya.mynotes

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.alignBy
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.shakya.mynotes.ui.theme.MyNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {}
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier=modifier, bottomBar ={ BottomAppBar()}) { contentPadding->
        LazyColumn(contentPadding=contentPadding) {

        }

    }
}

@Composable
fun BottomAppBar(modifier: Modifier = Modifier) {
    Row(modifier= modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)){
        TextField(value = "", onValueChange = {} , label = { Text(text = "Enter a Note")},
            modifier = Modifier
                .weight(0.8f)
                .fillMaxWidth())
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier
            .weight(0.2f)
            .fillMaxWidth()) {
            Icon(imageVector = Icons.AutoMirrored.Default.Send, contentDescription = null)
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MyNotesTheme {
        MainScreen()
           // BottomAppBar()
    }
}