package com.example.ramadan.rxjava_class.domain.source

import com.example.ramadan.rxjava_class.base.RxApp
import com.example.ramadan.rxjava_class.data.db.AppDatabase
import com.example.ramadan.rxjava_class.data.entities.Repo
import com.example.ramadan.rxjava_class.domain.repository.RepoDataSource
import io.reactivex.Observable
import io.reactivex.Single

object RepoLocalSource : RepoDataSource {

    override fun fetchRepos(username: String): Observable<List<Repo>> {


        return Observable.fromCallable {
            AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.fetchAllMyStarsRepos()
        }

    }

    override fun saveRepos(repos: List<Repo>) {
        AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllMyStarsRepos(repos)
    }

}