package com.jadepage.aboutme

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.jadepage.aboutme.databinding.ActivityAddHobbiesBinding
import com.jadepage.aboutme.models.Hobby
import com.jadepage.aboutme.repository.HobbyRepository

class AddHobbiesDialogFragment : DialogFragment() {
    private lateinit var onClickListener: OnClickListener

    interface OnClickListener {
        fun onDialogPositiveClick(hobby: Hobby?)
        fun onDialogNegativeClick(hobby: Hobby?)
    }

    companion object {
        fun create(onClickListener: OnClickListener): AddHobbiesDialogFragment {
            return AddHobbiesDialogFragment().apply {
                this.onClickListener = onClickListener
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val layoutInflater = LayoutInflater.from(requireContext())
            val binding = ActivityAddHobbiesBinding.inflate(layoutInflater)

            builder.setMessage(R.string.add_hobby)
            builder.setView(binding.root)
                    .setPositiveButton(R.string.yes
                    ) { _: DialogInterface, _: Int ->
                        val hobbyTitle = binding.hobbyTitleText.text.toString()
                        val hobbyDescription = binding.hobbyDescriptionText.text.toString()
                        val hobby = Hobby(hobbyTitle, hobbyDescription)

                        if (hobbyTitle != "") {
                            HobbyRepository.hobbies.add(hobby)
                        }
                        this.onClickListener.onDialogPositiveClick(hobby)
                    }
                    .setNegativeButton(R.string.no
                    ) { _, _ ->
                        dismiss()
                        val hobbyTitle = binding.hobbyTitleText.text.toString()
                        val hobbyDescription = binding.hobbyDescriptionText.text.toString()
                        val hobby = Hobby(hobbyTitle,hobbyDescription)
                        this.onClickListener.onDialogNegativeClick(hobby)
                    }
            builder.create()
        }?: throw IllegalStateException("Activity cannot be null")
    }
}