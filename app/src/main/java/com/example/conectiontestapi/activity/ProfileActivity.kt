package com.example.conectiontestapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conectiontestapi.R
import com.example.conectiontestapi.api.PersonApi
import com.example.conectiontestapi.api.PotterApi
import com.example.conectiontestapi.api.Retrofit
import com.example.conectiontestapi.model.AdapterPotter
import com.example.conectiontestapi.model.AdapterProfile
import kotlinx.android.synthetic.main.activity_profile.*
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

        val bundle: Bundle = intent.extras!!
        val id = bundle.getInt("id")
        val name = bundle.getString("name")
        supportActionBar!!.title = name

        getData(id)
    }

    private fun getData(id: Int){

        val remote = Retrofit.createService(PotterApi::class.java)
        val call: Call<List<PersonApi>> = remote.getPotterApi()
        call.enqueue(object: Callback<List<PersonApi>>{
            override fun onResponse(call: Call<List<PersonApi>>, response: Response<List<PersonApi>>) {

                val list = response.body()!![id]
                val wordAdd = "https"
                val itemS = list.image
                val subString = itemS.removeRange(0, 4)
                val https = (wordAdd + subString)
                Glide.with(this@ProfileActivity).load(https).into(image_id)

                val adapter = AdapterProfile(this@ProfileActivity, listOf(list))
                recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<List<PersonApi>>, t: Throwable) {
                Toast.makeText(this@ProfileActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })

    }

}