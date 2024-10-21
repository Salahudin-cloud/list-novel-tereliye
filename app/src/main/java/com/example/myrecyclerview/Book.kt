package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
