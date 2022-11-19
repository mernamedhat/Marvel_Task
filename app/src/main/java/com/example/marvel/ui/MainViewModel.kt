package com.example.marvel.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class MainViewModel : ViewModel() {

    fun getCharacters(
        ts: String,
        apikey: String,
        hash: String,
        offset: Int? = null,
        limit: Int? = null,
        name: String? = null
    ) = liveData {
        emit(MainRepository().getCharacters(ts, apikey, hash, offset, limit, name))
    }

}