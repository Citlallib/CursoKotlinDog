package com.vero.cursokotlindog.dogList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.R
import com.vero.cursokotlindog.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {
    //Instancia del ViewModel
    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.dogRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()
        recycler.adapter = adapter

        //crear observer
        dogListViewModel.dogList.observe(this){
            dogList->
            adapter.submitList(dogList)
        }
    }
}