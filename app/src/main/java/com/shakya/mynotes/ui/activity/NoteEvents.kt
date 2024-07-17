package com.shakya.mynotes.ui.activity

import com.shakya.mynotes.db.Note

sealed interface NoteEvents {
    data class AddOrEditEvent(val note : Note) : NoteEvents
    data class DeleteNote(val note: Note) : NoteEvents
    data object DeleteAll : NoteEvents
}