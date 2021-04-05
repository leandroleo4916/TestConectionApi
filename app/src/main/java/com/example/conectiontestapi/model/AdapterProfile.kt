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

        holder.nameId.text = list.name
        holder.sex.text = list.gender
        holder.actor.text = list.actor
        holder.birth.text = list.dateOfBirth
        holder.species.text = list.species
        holder.house.text = list.house
        holder.eye.text = list.eyeColour
        holder.ancestry.text = list.ancestry

    }

    override fun getItemCount(): Int {
        return listPerson.size
    }
}

class ViewHolderProfile(itemView: View): RecyclerView.ViewHolder(itemView){
    val nameId: TextView = itemView.findViewById(R.id.text_name)
    val sex: TextView = itemView.findViewById(R.id.text_sexo)
    val actor: TextView = itemView.findViewById(R.id.text_actor)
    val birth: TextView = itemView.findViewById(R.id.text_birth)
    val species: TextView = itemView.findViewById(R.id.text_species)
    val house: TextView = itemView.findViewById(R.id.text_house)
    val eye: TextView = itemView.findViewById(R.id.text_eye)
    val ancestry: TextView = itemView.findViewById(R.id.text_ancestry)
}