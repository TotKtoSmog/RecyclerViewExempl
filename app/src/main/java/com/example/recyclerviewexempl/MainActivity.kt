package com.example.recyclerviewexempl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewexempl.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder

data class Person(val firstname: String, val lastname: String)
class MainActivity : AppCompatActivity() {

    private lateinit var persons: List<Person>
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val resultString = application.assets.open("test.json")
            .bufferedReader().use{it.readText()}

        val gson = GsonBuilder().create()
        persons =  gson.fromJson(resultString, Array<Person>::class.java).toList()

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = MyAdapter(persons)

    }
}