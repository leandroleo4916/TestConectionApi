package com.example.conectiontestapi.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.conectiontestapi.R
import com.example.conectiontestapi.api.PersonApi

class AdapterPotter(private val context: Context, private val listPotter: List<PersonApi>)
    : RecyclerView.Adapter<ViewHolderPotter>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPotter {
        return ViewHolderPotter(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderPotter, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listPotter.size
    }
}

class ViewHolderPotter(itemView: View): RecyclerView.ViewHolder(itemView){
    val nameId: TextView = itemView.findViewById(R.id.text_name)
    val sex: TextView = itemView.findViewById(R.id.text_sexo)
    val actor: TextView = itemView.findViewById(R.id.text_actor)
    val birth: TextView = itemView.findViewById(R.id.text_birth)
    val species: TextView = itemView.findViewById(R.id.text_species)
    val house: TextView = itemView.findViewById(R.id.text_house)
    val eye: TextView = itemView.findViewById(R.id.text_eye)
    val ancestry: TextView = itemView.findViewById(R.id.text_ancestry)
}