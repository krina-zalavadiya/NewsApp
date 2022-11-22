package com.example.newsapp

class DatabaseModel {

    lateinit var key:String
    lateinit var name:String
    lateinit var std:String
    lateinit var phone:String





    constructor()
    {

    }

    constructor(key: String, name: String, std: String, phone: String) {
        this.key = key
        this.name = name
        this.std = std
        this.phone = phone
    }
}