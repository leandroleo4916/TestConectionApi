package com.example.conectiontestapi.model

import android.app.Person
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conectiontestapi.R
import com.example.conectiontestapi.api.PersonApi

class AdapterProfile(private val context: Context, private val listPerson: List<PersonApi>):
    RecyclerView.Adapter<ViewHolderProfile>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProfile {
        return ViewHolderProfile(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_profile, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderProfile, position: Int) {
        val list = listPerson[position]

        holder.name.text = list.name
        holder.birth.text = list.dateOfBirth

        val wordAdd = "https"
        val itemS = list.image
        val subString = itemS.removeRange(0, 4)
        val https = (wordAdd + subString)

        Glide.with(context).load(https).into(holder.image)

    }

    override fun getItemCount(): Int {
        return listPerson.size
    }
}

class ViewHolderProfile(itemView: View): RecyclerView.ViewHolder(itemView){
    val image: ImageView = itemView.findViewById(R.id.icon_image)
    val name: TextView = itemView.findViewById(R.id.text_name_id)
    val birth: TextView = itemView.findViewById(R.id.text_birth_id)
}