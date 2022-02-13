package ru.alexleru.gims.questions.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.alexleru.movieshustov.pojo.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).build()
                db = instance
                return instance
            }
        }
    }

    abstract fun gimsDao(): MovieDao
}