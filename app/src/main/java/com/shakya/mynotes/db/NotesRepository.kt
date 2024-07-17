package com.shakya.mynotes.db

import android.content.Context
import androidx.room.Room

class NotesRepository(private val context: Context) {
    private val database: NotesDatabase = Room
        .databaseBuilder(context, NotesDatabase::class.java, "notes.db")
        .fallbackToDestructiveMigration()
        .build()
    private val dao = database.notesDao()

    suspend fun insert(note: Note) = dao.insert(note)
    suspend fun delete(note: Note) = dao.delete(note)
    fun getAll() = dao.getAll()
    suspend fun deleteAll() = dao.deleteAll()
}
