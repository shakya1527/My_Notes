package com.shakya.mynotes.ui.activity.main

import com.shakya.mynotes.db.Note
import com.shakya.mynotes.utils.Theme

sealed interface NoteEvents {
    data class AddOrEditEvent(val note : Note) : NoteEvents
    data class DeleteNote(val note: Note) : NoteEvents
    data object DeleteAll : NoteEvents
    data class OnThemeChange(val theme : Theme) : NoteEvents
}