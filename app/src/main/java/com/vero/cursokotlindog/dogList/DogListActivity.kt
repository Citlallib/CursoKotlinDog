package com.vero.cursokotlindog.dogList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.vero.cursokotlindog.api.ApiResponseStatus
import com.vero.cursokotlindog.databinding.ActivityDogListBinding
import com.vero.cursokotlindog.dogDetail.DogDetailActivity
import com.vero.cursokotlindog.dogDetail.DogDetailActivity.Companion.DOG_KEY
private const val GRID_SPAN_COUNT = 3
class DogListActivity : AppCompatActivity() {
    //Instancia del ViewModel
    private val dogListViewModel: DogListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loadingWheel = binding.loadingWheel

        val recycler = binding.dogRecycler
        recycler.layoutManager = GridLayoutManager(this, GRID_SPAN_COUNT)

        val adapter = DogAdapter()

        adapter.setOnItemClickListener { dog ->
            //Pasar el Dog a DogDetailActivity a travez de un intent
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, dog)
            startActivity(intent)
        }
        recycler.adapter = adapter

        //crear observer
        dogListViewModel.dogList.observe(this) { dogList ->
            adapter.submitList(dogList)
        }
        //Observe de status
        dogListViewModel.status.observe(this) { status ->
            when (status) {
                is ApiResponseStatus.Error -> {
                    loadingWheel.visibility = View.GONE
                    Toast.makeText(this, status.messageId, Toast.LENGTH_SHORT).show()
                }
                is ApiResponseStatus.Loading -> loadingWheel.visibility = View.VISIBLE
                is ApiResponseStatus.Success -> loadingWheel.visibility = View.GONE
            }
        }
    }
}