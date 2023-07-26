package com.cercado.stranger_things

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cercado.stranger_things.databinding.ItemCharacterBinding
import com.cercado.stranger_things.model.CharacterData

class CharacterAdapter(var characters: List<CharacterData>): RecyclerView.Adapter<CharacterView> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterView {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CharacterView(binding)
    }


    override fun onBindViewHolder(holder: CharacterView, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

}

class  CharacterView(private var binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(character: CharacterData) {
        //binding.imgCharacter.setImageResource(R.drawable.icon_elements)
        //binding.imgCharacter.adjustViewBounds = character.photo
        Glide.with(binding.root)
            .load(character.photo)
            .into(binding.imgCharacter)

        binding.txtNameCharacter.text = character.name
        binding.txtBorn.text = character.born
        binding.txtGenre.text = character.gender
        binding.txtPortrayed.text = character.portrayedBy
        binding.txtStatus.text = character.status
    }

}