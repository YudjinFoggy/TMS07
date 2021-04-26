package com.example.tms07

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

class HW5DialogFragment : DialogFragment() {

    companion object {
        const val TAG = "dialog tag"
    }

    val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(ViewModelHW5::class.java)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.great_job))
            .setMessage(R.string.one_step_closer_to_space)
            .setIcon(R.drawable.ic_star)
            .setCancelable(true)
            .setNegativeButton(R.string.ok) { dialog, id ->
                dialog.dismiss()
            }
            .setPositiveButton(R.string.enter) { dialog, id ->
                startActivity(
                    Intent(requireActivity(), HW5ActivityRegistered::class.java).putExtra(
                        "welcome", viewModel.getLogin().value
                    )
                )
            }
            .create()
    }
}