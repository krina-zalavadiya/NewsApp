package com.example.newsapp.Adapter

import android.content.Context
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.DatabaseModel
import com.example.newsapp.R

private val Data.size: Int
    get() {
        TODO("Not yet implemented")
    }


class ShowListAdapter(data: DatabaseModel?) : RecyclerView.Adapter<ShowListAdapter.showHolder>() {
    lateinit var data:Data
    lateinit var context: Context
    class showHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.A_name)
        var email = itemView.findViewById<TextView>(R.id.A_email)
        var phone = itemView.findViewById<TextView>(R.id.A_phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showHolder {
        context = parent.context
        return showHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_show_item,parent,false))
    }

    override fun onBindViewHolder(holder: showHolder, position: Int) {

        holder.name.setText(data.toString())
        holder.email.setText(data.toString())
        holder.phone.setText(data.toString())

    }

    override fun getItemCount(): Int {
            return data.size
    }
}