package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.newsapp.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException

class MainActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.register.setOnClickListener {

            var email = binding.email.text.toString()
            var password = binding.password.text.toString()

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener( { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this@MainActivity, "Is Successfull Data Add", Toast.LENGTH_SHORT).show()

                }
            })
        }
    }
}