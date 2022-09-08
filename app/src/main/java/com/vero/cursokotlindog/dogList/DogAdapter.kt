package com.vero.cursokotlindog.dogList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vero.cursokotlindog.Dog
import com.vero.cursokotlindog.databinding.DogListItemBinding

class DogAdapter: ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {
    // Le dice a la lista como resper cuando se edita un elemento
    companion object DiffCallback : DiffUtil.ItemCallback<Dog>(){
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id == newItem.id
        }

    }
    //Lambda que se le pasa un perro que se le sa click
    private var onItemClickListener: ((Dog) -> Unit)? = null
    //método que recibe lambda
    fun setOnItemClickListener(onItemClickListener: (Dog) -> Unit){
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogListItemBinding
            .inflate(LayoutInflater.from(parent.context))
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        dogViewHolder.bind(dog)
    }

    inner class DogViewHolder(val binding: DogListItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind (dog: Dog){
            binding.dogName.text = dog.name
            //Cuando se clickee el dogname
            binding.dogName.setOnClickListener {
                //Si no es null se va a invocar
                onItemClickListener?.invoke(dog)
            }
        }
    }
}