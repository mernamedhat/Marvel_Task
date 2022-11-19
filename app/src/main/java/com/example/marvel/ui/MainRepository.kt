package com.example.marvel.ui.home

import com.example.marvel.api.ServiceBuilder


class MainRepository {

    suspend fun getCharacters(
        ts: String,
        apikey: String,
        hash: String,
        offset: Int? = null,
        limit: Int? = null,
        name: String? = null
    ) = ServiceBuilder.buildService().getCharacters(ts, apikey, hash, offset, limit, name)
}