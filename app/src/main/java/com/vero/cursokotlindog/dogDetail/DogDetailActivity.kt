package com.vero.cursokotlindog.dogDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import coil.load
import com.vero.cursokotlindog.model.Dog
import com.vero.cursokotlindog.R
import com.vero.cursokotlindog.databinding.ActivityDogDetailBinding

class DogDetailActivity : AppCompatActivity() {
    companion object{
        //Llave para pasar el perro
        const val DOG_KEY = "dog"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = intent?.extras?.getParcelable<Dog>(DOG_KEY)

        if (dog==null){
            Toast.makeText(this, R.string.error_showing_dog_not_found, Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        binding.dogIndex.text = getString(R.string.dog_index_format, dog.index)
        binding.lifeExpectancy.text = getString(R.string.dog_life_expectancy_format, dog.lifeExpectancy)
        binding.dog = dog
        binding.dogImage.load(dog.imageUrl)
        binding.closeButton.setOnClickListener{
            finish()
        }
    }
}