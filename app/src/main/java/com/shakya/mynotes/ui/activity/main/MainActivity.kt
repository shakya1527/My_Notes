package com.shakya.mynotes.ui.activity.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.alignBy
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.shakya.mynotes.ui.MyNotesNavigation
import com.shakya.mynotes.ui.theme.MyNotesTheme
import com.shakya.mynotes.utils.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val theme by viewModel.currentTheme
            MyNotesTheme(
                darkTheme = when (theme) {
                    Theme.AUTO -> isSystemInDarkTheme()
                    Theme.LIGHT -> false
                    Theme.DARK -> true
                }
            ) {
                MyNotesNavigation(
                    navHostController = rememberNavController(),
                    notes = viewModel.notes.collectAsState(
                        initial = emptyList()
                    ).value,
                    onEvent = viewModel::onEvent,
                    theme = theme
                )
            }
        }
    }

}

