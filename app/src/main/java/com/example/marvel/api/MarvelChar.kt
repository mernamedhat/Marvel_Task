package com.example.marvel

data class Response(val data: Data)
data class Data(val results: ArrayList<MarvelChar>)
data class MarvelChar(val id: Int, val name: String,val thumbnail: Thumbnail)
data class Thumbnail(val path: String,val extension:String)
