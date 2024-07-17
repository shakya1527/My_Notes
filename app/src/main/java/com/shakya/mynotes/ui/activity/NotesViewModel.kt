package com.shakya.mynotes.ui.activity

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shakya.mynotes.db.NotesRepository
import com.shakya.mynotes.utils.Theme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val repository: NotesRepository,
    private val preferences: SharedPreferences
) : ViewModel() {
    val notes = repository.getAll()
    private val _currentTheme = mutableStateOf(
        Theme.valueOf(
            preferences.getString("theme", Theme.AUTO.name) ?: Theme.AUTO.name
        )
    )
    val currentTheme: State<Theme> get() = _currentTheme
    fun onEvent(event: NoteEvents) {
        when (event) {
            is NoteEvents.AddOrEditEvent -> viewModelScope.launch {
                repository.insert(event.note)
            }

            NoteEvents.DeleteAll -> viewModelScope.launch {
                repository.deleteAll()
            }

            is NoteEvents.DeleteNote -> viewModelScope.launch {
                repository.delete(event.note)
            }

            is NoteEvents.OnThemeChange -> {
                _currentTheme.value = event.theme
                preferences.edit().putString("theme", event.theme.name).apply()
            }
        }
    }
}
