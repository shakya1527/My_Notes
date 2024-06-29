package com.shakya.mynotes.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shakya.mynotes.db.Note
import com.shakya.mynotes.db.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(private val repository: NotesRepository) : ViewModel() {
    val notes = repository.getAll()
    fun addNote(note: Note) = viewModelScope.launch {
        repository.insert(note)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        repository.delete(note)
    }

    companion object {
        fun provideFactory(repository: NotesRepository): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
                        @Suppress("UNCHECKED_CAST")
                        return NotesViewModel(repository) as T
                    }
                    throw IllegalArgumentException("Unknown ViewMode){}lClass")
                }

            }
        }
    }
}
