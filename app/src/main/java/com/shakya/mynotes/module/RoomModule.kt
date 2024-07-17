package com.shakya.mynotes.module

import android.content.Context
import androidx.room.Room
import com.shakya.mynotes.db.NotesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext
        context : Context
    ) : NotesDatabase =
        Room
            .databaseBuilder(context, NotesDatabase::class.java, "notes.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideNotesDao(database: NotesDatabase) = database.notesDao()

}