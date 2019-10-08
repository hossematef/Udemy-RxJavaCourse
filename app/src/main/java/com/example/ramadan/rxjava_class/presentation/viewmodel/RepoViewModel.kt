package com.example.ramadan.rxjava_class.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ramadan.rxjava_class.base.BaseViewModel
import com.example.ramadan.rxjava_class.data.entities.Repo
import com.example.ramadan.rxjava_class.domain.repository.NetworkState
import com.example.ramadan.rxjava_class.domain.source.RepoLocalSource
import com.example.ramadan.rxjava_class.domain.source.RepoRemoteSource
import com.example.ramadan.rxjava_class.domain.repository.RepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RepoViewModel : BaseViewModel() {
    private val repoLiveData = MutableLiveData<List<Repo>>()
    //private val errorLiveData = MutableLiveData<String>()
    private val repository = RepoRepository(RepoRemoteSource, RepoLocalSource)

    fun getMyStarsRepos(username:String){
        if (repoLiveData.value !=null){
            return
        }

        addToDisposable(repository.fetchRepos(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                    repoLiveData.value = it
                })
    }

    val networkState : LiveData<NetworkState> by lazy {
        repository.getMovieDetailsNetworkState()
    }

    val error : LiveData<String> by lazy {
        repository.getError()
    }


    fun getLiveData():LiveData<List<Repo>> = repoLiveData
    //fun errorLiveData():LiveData<String> = errorLiveData


}