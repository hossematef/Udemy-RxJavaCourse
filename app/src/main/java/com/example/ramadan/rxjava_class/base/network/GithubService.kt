package com.example.ramadan.rxjava_class.base.network

import com.example.ramadan.rxjava_class.data.entities.Repo
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/starred")
    fun getStarredRepos(@Path("user") username:String): Observable<List<Repo>>
}