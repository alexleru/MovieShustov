package ru.alexleru.movieshustov.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Popular(
@SerializedName("results")
@Expose(serialize = false)
val results: List<Movie>
)