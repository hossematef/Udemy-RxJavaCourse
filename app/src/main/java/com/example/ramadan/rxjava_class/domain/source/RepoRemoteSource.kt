package com.example.ramadan.rxjava_class.domain.source

import com.example.ramadan.rxjava_class.data.entities.Repo
import com.example.ramadan.rxjava_class.base.network.GithubApiClient
import com.example.ramadan.rxjava_class.data.entities.RepoResponse
import com.example.ramadan.rxjava_class.domain.repository.RepoDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

object RepoRemoteSource : RepoDataSource {
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return GithubApiClient.getGithubSerivce().getStarredRepos(username)
    }


    override fun saveRepos(repos: List<Repo>) {
    }
}