package com.example.conectiontestapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conectiontestapi.R
import com.example.conectiontestapi.api.PersonApi
import com.example.conectiontestapi.api.PotterApi
import com.example.conectiontestapi.api.Retrofit
import com.example.conectiontestapi.model.AdapterPotter
import com.example.conectiontestapi.model.AdapterProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(findViewById<View>(R.id.toolbar_profile) as Toolbar)
        //Mostra o icone voltar na tollbar
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recycler_profile)
        recyclerView.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData(){

        val remote = Retrofit.createService(PotterApi::class.java)
        val call: Call<List<PersonApi>> = remote.getPotterApi()
        call.enqueue(object: Callback<List<PersonApi>>{
            override fun onResponse(call: Call<List<PersonApi>>, response: Response<List<PersonApi>>) {
                val adapter = AdapterProfile(this@ProfileActivity, response.body()!!.toList())
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<PersonApi>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}