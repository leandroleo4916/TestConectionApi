package com.example.conectiontestapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conectiontestapi.R
import com.example.conectiontestapi.api.PersonApi
import com.example.conectiontestapi.api.PotterApi
import com.example.conectiontestapi.api.Retrofit
import com.example.conectiontestapi.model.AdapterPotter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById<View>(R.id.toolbar) as Toolbar)
        //esconde icone voltar na toolbar
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        recyclerView = findViewById(R.id.recycler_potter)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getData()

    }

    private fun getData(){

        val retrofit = Retrofit.createService(PotterApi::class.java)

        val call: Call<List<PersonApi>> = retrofit.getPotterApi()

        call.enqueue(object: Callback<List<PersonApi>>{
            override fun onResponse(call: Call<List<PersonApi>>, response: Response<List<PersonApi>>){
                val adapter = AdapterPotter(this@MainActivity, response.body()!!.toList())
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<PersonApi>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}