package com.example.fragmentsetup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.fragmentsetup.data.DataViewModel
import com.example.fragmentsetup.databinding.FragmentRecycleBinding
import com.example.fragmentsetup.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass.
 * Use the [RecycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecycleFragment : Fragment() {
    lateinit var viewModel : DataViewModel
    var _binding : FragmentRecycleBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecycleBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        val list = viewModel.getMessages()
        list.forEach { str ->
            Log.d(this.javaClass.name, str)
        }

        binding.listviewR.adapter = RecycleViewAdapter(requireContext(), viewModel)

        binding.button2.setOnClickListener {
            val action = RecycleFragmentDirections.actionRecycleFragmentToThirdFragment("recycle Test ===>")
            view.findNavController().navigate(action)
        }
        binding.textView2R.text = SecondFragmentArgs.fromBundle(requireArguments()).seValue

        return view
    }

}