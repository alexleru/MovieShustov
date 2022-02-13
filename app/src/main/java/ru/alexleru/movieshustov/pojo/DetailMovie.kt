package ru.alexleru.movieshustov.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detail")
data class DetailMovie (
        @PrimaryKey
        @SerializedName("id")
        @Expose(serialize = false)
        val id: Int,
        @SerializedName("original_title")
        @Expose(serialize = false)
        val originalTitle: String,
        @SerializedName("release_date")
        @Expose(serialize = false)
        val releaseDate: String,
        @SerializedName("poster_path")
        @Expose(serialize = false)
        val posterPath: String,
        @SerializedName("vote_average")
        @Expose(serialize = false)
        val voteAverage: Double
        )