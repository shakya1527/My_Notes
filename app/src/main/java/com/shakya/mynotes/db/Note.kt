package com.shakya.mynotes.db

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Note(
    val title: String ,
    val description : String,
    val created : Long=System.currentTimeMillis()
)
fun Long.toFormattedDate(): String {
    val sdf = SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH)
    val date = Date(this)
    return sdf.format(date).uppercase()
}


