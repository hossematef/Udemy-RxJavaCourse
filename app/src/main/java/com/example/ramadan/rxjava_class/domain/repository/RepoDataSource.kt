package com.example.ramadan.rxjava_class.domain.repository

import com.example.ramadan.rxjava_class.data.entities.Repo
import io.reactivex.Observable
import io.reactivex.Single

interface RepoDataSource {
    fun fetchRepos(username:String) : Observable<List<Repo>>
    fun saveRepos(repos :List<Repo>)
}