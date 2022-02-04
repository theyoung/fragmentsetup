package com.example.fragmentsetup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.fragmentsetup.data.DataViewModel
import com.example.fragmentsetup.databinding.FragmentSecondBinding
import com.example.fragmentsetup.databinding.FragmentTestBinding


/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    lateinit var viewModel : DataViewModel
    var _binding : FragmentSecondBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_second, container, false)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        val list = viewModel.getMessages()
        list.forEach { str ->
            Log.d(this.javaClass.name, str)
        }

        binding.listview.adapter = ListViewAdapter(requireContext(), viewModel)

        binding.button2.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment("Test Value ==>")
            view.findNavController().navigate(action)
        }
        binding.textView2.text = SecondFragmentArgs.fromBundle(requireArguments()).seValue

        return view
    }

    fun deletePositionData(position:Int){
        viewModel.removeDataAt(position)
    }

}