package com.example.ramadan.rxjava_class.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import android.content.Context
import com.example.ramadan.rxjava_class.data.entities.Repo


@Database(entities = [Repo::class], version = 1)
abstract  class AppDatabase  : RoomDatabase(){
    abstract fun getRepoDao() :RepoDAO

    companion object {
        var INSTANCE :AppDatabase? = null

        fun getInstance(context:Context):AppDatabase?{
            INSTANCE?.let { INSTANCE }?:run {
                INSTANCE = Room.databaseBuilder(context,AppDatabase::class.java,"repo.db").build()
            }

           return INSTANCE
        }
    }

}