package com.example.marvel


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.Ui.Home.MainAdapter
import com.example.marvel.Ui.Home.MainViewModel
import com.example.marvel.Ui.Home.ProgressBarAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigInteger
import java.security.MessageDigest


class MainActivity : AppCompatActivity() {

    lateinit var mainAdapter: MainAdapter
    lateinit var progressBarAdapter: ProgressBarAdapter
    var offset = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arrayList = ArrayList<MarvelChar>()
        val timeStamp = System.currentTimeMillis().toString()
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getCharacters(timeStamp, PUBLIC_KEY,
            getHash(timeStamp + PRIVATE_KEY + PUBLIC_KEY),
            offset
        ).observe(this) {
            arrayList.addAll(it.data.results)
            mainAdapter = MainAdapter(arrayList)
            progressBarAdapter= ProgressBarAdapter()
            val listOfAdapters = listOf(mainAdapter, progressBarAdapter)
            marvel_rec.adapter =  ConcatAdapter(listOfAdapters)
        }

        marvel_rec.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    progressBarAdapter= ProgressBarAdapter()
                    marvel_rec.adapter?.notifyDataSetChanged()
                    offset += 20
                    viewModel.getCharacters(timeStamp,
                        PUBLIC_KEY,
                        getHash(timeStamp + PRIVATE_KEY + PUBLIC_KEY),
                        offset
                    ).observe(this@MainActivity) {
                        arrayList.addAll(it.data.results)
                        mainAdapter.notifyDataSetChanged()
                        progressBarAdapter= ProgressBarAdapter()
                        marvel_rec.adapter?.notifyDataSetChanged()
                    }
                }
            }
        })


    }

    fun getHash(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(
            1,
            md.digest(input.toByteArray())
        )
            .toString(16)
            .padStart(32, '0')
    }

    companion object {
        const val PUBLIC_KEY = "91c90acb3adaf7b9b9e5bcc1f1cfe781"
        const val PRIVATE_KEY = "cd2ed2acaaf9fb0c293607f24f864c87760993ce"
    }
}