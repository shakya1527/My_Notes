package com.shakya.mynotes.db

data class Note(
    val title: String ,
    val description : String,
    val created : Long=System.currentTimeMillis()
)
