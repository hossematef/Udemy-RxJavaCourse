package com.example.ramadan.rxjava_class.domain.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ramadan.rxjava_class.data.entities.Repo
import com.example.ramadan.rxjava_class.domain.source.RepoLocalSource
import com.example.ramadan.rxjava_class.domain.source.RepoRemoteSource
import com.example.ramadan.rxjava_class.presentation.ui.netWorkError
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

class RepoRepository(private val repoRemoteSource: RepoRemoteSource, private val repoLocalSource: RepoLocalSource) : RepoDataSource {

    private val networkState: MutableLiveData<NetworkState> = MutableLiveData()
    private val errorState: MutableLiveData<String> = MutableLiveData()


    override fun fetchRepos(username: String): Observable<List<Repo>> {

        networkState.postValue(NetworkState.LOADING)

        return Observable.concat(repoLocalSource.fetchRepos(username),
                repoRemoteSource.fetchRepos(username)
                        .doOnNext {

                             saveRepos(it)
                            networkState.postValue(NetworkState.LOADED)
                        }.doOnError {
                            errorState.postValue(netWorkError(it))
                            networkState.postValue(NetworkState.ERROR)
                        }
                        .onErrorResumeNext(Observable.empty())

        )

    }




    override fun saveRepos(repos: List<Repo>) {
        RepoLocalSource.saveRepos(repos)

    }

    fun getMovieDetailsNetworkState(): LiveData <NetworkState> {
        return networkState
    }

    fun getError(): LiveData<String> {
        return errorState
    }



}