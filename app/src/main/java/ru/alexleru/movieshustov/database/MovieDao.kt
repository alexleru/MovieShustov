package ru.alexleru.movieshustov.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.alexleru.movieshustov.pojo.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(itemList: List<Movie>)

    @Query("DELETE FROM movie")
    fun deleteAll()

    @Query("SELECT * FROM movie")
    fun queryMovieList() : LiveData<List<Movie>>

}