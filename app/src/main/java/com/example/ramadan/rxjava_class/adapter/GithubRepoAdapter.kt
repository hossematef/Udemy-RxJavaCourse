package com.example.ramadan.rxjava_class.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.ramadan.rxjava_class.databinding.StarsItemBinding
import com.example.ramadan.rxjava_class.data.entities.Repo

class GithubRepoAdapter  : RecyclerView.Adapter<GithubRepoAdapter.StarRepoViewHolder>(){

     var data = ArrayList<Repo>()
//         set(value) {
//             field = value
//             notifyDataSetChanged()
//         }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StarsItemBinding.inflate(inflater)
        return StarRepoViewHolder(binding)
    }

    override fun getItemCount()=data.size


    override fun onBindViewHolder(viewHolder: StarRepoViewHolder, position: Int) = viewHolder.bind(data[position])



    fun addRepos(repos: ArrayList<Repo>) {
        data.clear()
        data.addAll(repos)
        notifyDataSetChanged()
    }

     class StarRepoViewHolder(private val binding : StarsItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (repo: Repo){
            binding.item = repo
            binding.executePendingBindings()
        }



    }
}