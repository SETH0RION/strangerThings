package com.cercado.stranger_things.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cercado.stranger_things.CharacterAdapter
import com.cercado.stranger_things.databinding.FragmentElementsBinding


class ElementsFragment : Fragment() {
    private lateinit var binding:FragmentElementsBinding
    private lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentElementsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(listOf())
        binding.recycleViewElement.adapter = adapter
        binding.recycleViewElement.layoutManager = GridLayoutManager(requireContext(),1,RecyclerView.VERTICAL,false)

        viewModel.characterList.observe(requireActivity()){
            adapter.characters = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getCharacterFromService()


    }

}