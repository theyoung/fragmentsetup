package com.example.fragmentsetup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        view.findViewById<Button>(R.id.button3).setOnClickListener {
            view.findNavController().popBackStack()
        }
        val param = ThirdFragmentArgs.fromBundle(requireArguments()).str
        view.findViewById<TextView>(R.id.textView3).text = param
        return view

    }

}