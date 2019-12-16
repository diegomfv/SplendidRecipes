package com.diegomfv.splendidrecipesmvvm.data.database

import androidx.room.*
import com.diegomfv.splendidrecipesmvvm.data.database.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM Movie")
    fun getAll(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun findById(id: Int): Movie

    @Query("SELECT COUNT(id) FROM Movie")
    fun movieCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)
}