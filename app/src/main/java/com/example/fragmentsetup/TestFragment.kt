package com.example.fragmentsetup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            val str = view.findViewById<EditText>(R.id.editTextTextPersonName).text.toString() ?: "hello"
            val action = TestFragmentDirections.actionTestFragmentToSecondFragment(str)
            view.findNavController().navigate(action)
        }
        return view
    }

}