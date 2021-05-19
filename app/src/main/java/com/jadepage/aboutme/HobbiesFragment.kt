package com.jadepage.aboutme

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.jadepage.aboutme.databinding.FragmentHobbiesBinding
import com.jadepage.aboutme.models.Hobby

class HobbiesFragment: Fragment(R.layout.fragment_hobbies), AddHobbiesDialogFragment.OnClickListener {

    private var fragmentHobbyBinding: FragmentHobbiesBinding? = null

    private fun showDialog() {
        val dialog = AddHobbiesDialogFragment.create(this)
        dialog.show(parentFragmentManager, "HobbiesFragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHobbiesBinding.bind(view)
        fragmentHobbyBinding = binding
        binding.floatingActionButton.setOnClickListener {
            Log.d("FAB", "Fab got clicked in onViewCreated")
            showDialog()
        }
        binding.hobbiesList.adapter = HobbiesViewAdapter()
        binding.hobbiesList.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
    }

    override fun onDialogPositiveClick(hobby: Hobby?) {}

    override fun onDialogNegativeClick(hobby : Hobby?) {}
}