package com.example.ramadan.rxjava_class.data.entities

import com.google.gson.annotations.SerializedName



data class RepoResponse (
                 @SerializedName("id")  val id:String,
                 @SerializedName("name")  val name:String,
                 @SerializedName("description") val desc:String?,
                 @SerializedName("language") val lang:String?,
                 @SerializedName("stargazers_count") val starCount:Int
)