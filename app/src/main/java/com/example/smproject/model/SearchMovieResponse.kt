package com.example.smproject.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchMovieResponse(
    val Search: List<Search>,
    val totalResults: String,
    val Response: String
)
@JsonClass(generateAdapter = true)
data class Search(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster: String
)
