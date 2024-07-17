package com.shakya.mynotes.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.alignBy
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.shakya.mynotes.ui.MyNotesNavigation
import com.shakya.mynotes.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNotesTheme {
                MyNotesNavigation(
                    navHostController = rememberNavController(),
                    notes = viewModel.notes.collectAsState(
                        initial = emptyList()
                    ).value,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }

}

