package com.example.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapp.databinding.ActivityFiredatabaseBinding
import com.example.newsapp.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Firedatabase : AppCompatActivity() {

    lateinit var reference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_firedatabase)

        var binding = ActivityFiredatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        reference = FirebaseDatabase.getInstance().getReference()
        binding.submit.setOnClickListener {


            var name =    binding.name.text.toString()
            var std =    binding.std.text.toString()
            var phone =    binding.phone.text.toString()

            var key = reference.root.push().key

            var profile = DatabaseModel(key!!,name,std,phone)
            reference.root.child("data").child(key).setValue(profile)

            intent = Intent(applicationContext, ShowData::class.java)

            startActivity(intent)
        }


    }
}