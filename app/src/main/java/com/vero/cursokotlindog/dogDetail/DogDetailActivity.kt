package com.vero.cursokotlindog.dogDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vero.cursokotlindog.databinding.ActivityDogListBinding

class DogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}