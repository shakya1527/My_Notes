package com.shakya.mynotes.db

import android.content.Context
import androidx.room.Room

class NotesRepository(private val context: Context) {
    private var database: NotesDatabase = Room
        .databaseBuilder(context, NotesDatabase::class.java, "notes.db")
        .fallbackToDestructiveMigration()
        .build()

    suspend fun insert(note: Note) = database.notesDao().insert(note)
    suspend fun delete(note: Note) = database.notesDao().delete(note)
    fun getAll() = database.notesDao().getAll()
    suspend fun deleteAll() = database.notesDao().deleteAll()
}
