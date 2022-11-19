package com.example.marvel.Ui.Home

import com.example.marvel.Api.ServiceBuilder


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