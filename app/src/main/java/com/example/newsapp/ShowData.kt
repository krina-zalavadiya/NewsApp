package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.newsapp.Adapter.ShowListAdapter
import com.example.newsapp.databinding.ActivityShowDataBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class ShowData : AppCompatActivity() {

    lateinit var reference: DatabaseReference

    var datalist = ArrayList<DatabaseModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)

        var binding = ActivityShowDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        reference.root.child("Data").addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                for (snap in snapshot.children){


                    var data  = snap.getValue(DatabaseModel::class.java)
                    datalist.add(data!!)


                }

                for ( d in datalist){

                    binding.showlist.layoutManager = GridLayoutManager(applicationContext,1)
                    val data = null
                    binding.showlist.adapter = ShowListAdapter(data)
                }


            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }


}