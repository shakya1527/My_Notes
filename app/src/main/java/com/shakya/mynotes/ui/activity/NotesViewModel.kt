package com.shakya.mynotes.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.db.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(private val repository: NotesRepository) : ViewModel() {
    val notes = repository.getAll()


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
        }
    }
}
