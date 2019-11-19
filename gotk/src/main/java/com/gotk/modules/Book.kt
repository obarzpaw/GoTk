package com.gotk.models

data class Book(
    val authors: List<String>,
    val characters: List<String>,
    val country: String,
    val isbn: String,
    val mediaType: String,
    val name: String,
    val numberOfPages: Int,
    val povCharacters: List<String>,
    val publisher: String,
    val released: String,
    val url: String
)