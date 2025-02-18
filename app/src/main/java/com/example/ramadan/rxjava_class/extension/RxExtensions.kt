package com.example.ramadan.rxjava_class.extension

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.with(): Single<T> = subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())