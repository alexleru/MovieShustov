package ru.alexleru.gims.questions.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.alexleru.movieshustov.pojo.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(itemList: List<Movie>)

    @Query("SELECT * FROM movie")
    fun queryMovieList() : LiveData<List<Movie>>

}