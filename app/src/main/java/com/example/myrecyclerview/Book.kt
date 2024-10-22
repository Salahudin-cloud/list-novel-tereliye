package com.example.myrecyclerview


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Book(
    val photo : Int,
    val name:String,
    val penerbit:String,
    val terbit:String,
    val genre:String,
    val halaman:String,
    val desc:String,

) : Parcelable
