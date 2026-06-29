package com.example.proyectofinal.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        JugadorLocalEntity::class,
        ProgresoLocalEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class EscapeUamDatabase : RoomDatabase() {

    abstract fun escapeUamDao(): EscapeUamDao

    companion object {
        @Volatile
        private var INSTANCE: EscapeUamDatabase? = null

        fun getDatabase(context: Context): EscapeUamDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EscapeUamDatabase::class.java,
                    "escape_uam_local_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}