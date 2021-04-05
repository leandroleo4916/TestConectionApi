package com.example.conectiontestapi.model

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.conectiontestapi.R
import com.example.conectiontestapi.activity.ProfileActivity
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
        val list = listPotter[position]

        holder.name.text = list.name
        holder.birth.text = list.dateOfBirth

        val wordAdd = "https"
        val itemS = list.image
        val subString = itemS.removeRange(0, 4)
        val https = (wordAdd + subString)

        Glide.with(context).load(https).into(holder.image)

        holder.itemView.setOnClickListener {

            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("id", position)
            intent.putExtra("name", list.name)
            context.startActivities(arrayOf(intent))
        }

    }

    override fun getItemCount(): Int {
        return listPotter.size
    }
}

class ViewHolderPotter(itemView: View): RecyclerView.ViewHolder(itemView){

    val image: ImageView = itemView.findViewById(R.id.icon_image)
    val name: TextView = itemView.findViewById(R.id.text_name_id)
    val birth: TextView = itemView.findViewById(R.id.text_birth_id)

}