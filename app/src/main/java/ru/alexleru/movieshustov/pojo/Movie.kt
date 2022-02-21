package ru.alexleru.movieshustov.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.alexleru.movieshustov.api.ApiFactory.BASE_URL_IMAGE

@Entity(tableName = "movie")
data class Movie(
    @PrimaryKey
    @SerializedName("id")
    @Expose(serialize = false)
    val id: Int,
    @SerializedName("title")
    @Expose(serialize = false)
    val title: String? = null,
    @SerializedName("release_date")
    @Expose(serialize = false)
    val releaseDate: String? = null,
    @SerializedName("poster_path")
    @Expose(serialize = false)
    val posterPath: String? = null,
    @SerializedName("overview")
    @Expose(serialize = false)
    val overview: String? = null,
    @SerializedName("vote_average")
    @Expose(serialize = false)
    val voteAverage: Double? = null
) {
    fun year(): String {
        return releaseDate?.substring(0,4) ?: ""
    }

    fun getFullImageUrl(): String {
        return BASE_URL_IMAGE + posterPath
    }

}