package com.example.ramadan.rxjava_class.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ramadan.rxjava_class.data.entities.Repo

@Dao
interface RepoDAO {

    @Query(" SELECT * FROM repo")
    fun fetchAllMyStarsRepos(): List<Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllMyStarsRepos(repos: List<Repo>)

}