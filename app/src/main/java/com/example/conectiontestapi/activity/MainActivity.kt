package com.example.conectiontestapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conectiontestapi.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById<View>(R.id.toolbar) as Toolbar)
        //hide icon back from tollbar
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        recyclerView = findViewById(R.id.recycler_potter)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}