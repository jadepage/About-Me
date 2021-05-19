package com.jadepage.aboutme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jadepage.aboutme.databinding.ItemHobbyBinding
import com.jadepage.aboutme.models.Hobby
import com.jadepage.aboutme.repository.HobbyRepository


class HobbiesViewAdapter : RecyclerView.Adapter<HobbiesViewAdapter.HobbiesViewHolder>()
{
    class HobbiesViewHolder(private val binding: ItemHobbyBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bind(hobby: Hobby) {
            binding.hobbyTitle.text = hobby.title
            binding.hobbyDescription.text = hobby.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemHobbyBinding.inflate(layoutInflater, parent, false)
        return HobbiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        holder.bind(HobbyRepository.hobbies[position])
    }

    override fun getItemCount() = HobbyRepository.hobbies.size
}