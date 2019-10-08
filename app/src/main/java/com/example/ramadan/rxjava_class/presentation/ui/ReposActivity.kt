package com.example.ramadan.rxjava_class.presentation.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ramadan.rxjava_class.R
import com.example.ramadan.rxjava_class.adapter.GithubRepoAdapter
import com.example.ramadan.rxjava_class.domain.repository.NetworkState
import com.example.ramadan.rxjava_class.presentation.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.activity_repos.*

class ReposActivity : AppCompatActivity() {

    private lateinit var repoAdapter :GithubRepoAdapter
    private lateinit var repoViewModel :RepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repos)


        val linearLayoutmg = LinearLayoutManager(applicationContext)
        val divider = DividerItemDecoration(myStarsList.context, DividerItemDecoration.VERTICAL)
        myStarsList.layoutManager = linearLayoutmg
        repoAdapter = GithubRepoAdapter()
        myStarsList.adapter = repoAdapter
        myStarsList.addItemDecoration(divider)

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)

        repoViewModel.networkState.observe(this, Observer {
            progressBar.visibility = if (it == NetworkState.LOADING) View.VISIBLE else View.GONE
            if(it==NetworkState.LOADING){
                Log.d("state","Loading")
            }else{
                Log.d("state","else")
            }
            //txt_error.visibility = if (it == NetworkState.ERROR) View.VISIBLE else View.GONE

        })

        repoViewModel.error.observe(this, Observer {
            Log.d("errorCode",it)
        })




        getStarredRepos(repoViewModel)

        observeMyStars(repoViewModel)


        //repoViewModel.errorLiveData()

    }


    private fun getStarredRepos(viewModel :RepoViewModel){
        viewModel.getMyStarsRepos("JakeWharton")
    }

    private fun observeMyStars(viewModel:RepoViewModel){
        viewModel.getLiveData().observe(this, Observer {
            repos -> repoAdapter.addRepos(ArrayList(repos))
        })
    }
}
