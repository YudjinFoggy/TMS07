package com.example.tms07

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class StepFirstFragment : Fragment() {

    val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModelSnowdrop::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_step_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val enterName = view.findViewById<EditText>(R.id.name_snowdrop)
        val enterLengthBuld = view.findViewById<EditText>(R.id.length_buld)
        val enterLength = view.findViewById<EditText>(R.id.length_snowdrop)

        val buttonSave = view.findViewById<Button>(R.id.button_save)
        val messageAboutAdded = MessageAboutAddedFragment()

        buttonSave.setOnClickListener {
            if (enterName.text.toString().isEmpty()) {
                enterName.error = "Name sholdn't be empty"
            }
            if (enterLengthBuld.text.toString().isEmpty()) {
                enterLengthBuld.error = "It sholdn't be empty"
            }
            if (enterLength.text.toString().isEmpty()) {
                enterLength.error = "It sholdn't be empty"
            } else {
                viewModel.setValuesInFragment(
                    enterName.text.toString(),
                    enterLengthBuld.text.toString().toInt(),
                    enterLength.text.toString().toInt()
                )

                enterName.text = null
                enterLengthBuld.text = null
                enterLength.text = null

                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, messageAboutAdded).commit();
            }
        }
    }
}