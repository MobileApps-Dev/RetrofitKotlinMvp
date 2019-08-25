package com.example.retrofitkotlinmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recycle: RecyclerView
    var mainPresenter: MainPresenterImpl? = null
    lateinit var client : RestClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        recycle = findViewById(R.id.recycle)
        recycle.layoutManager = LinearLayoutManager(this)
        client = RestClient

        mainPresenter = MainPresenterImpl(this,this)
        mainPresenter!!.requestDataFromServer()
    }


}
