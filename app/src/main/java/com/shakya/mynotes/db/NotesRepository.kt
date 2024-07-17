package com.shakya.mynotes.db

import android.content.Context
import androidx.room.Room
import javax.inject.Inject

class NotesRepository @Inject constructor(private val dao : NotesDao) {


    suspend fun insert(note: Note) = dao.insert(note)
    suspend fun delete(note: Note) = dao.delete(note)
    fun getAll() = dao.getAll()
    suspend fun deleteAll() = dao.deleteAll()
}
