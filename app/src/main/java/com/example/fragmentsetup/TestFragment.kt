package com.example.fragmentsetup

import android.os.Bundle
import android.util.Log
import android.util.Log.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.fragmentsetup.data.DataViewModel
import com.example.fragmentsetup.databinding.FragmentTestBinding
import java.util.logging.Level.INFO
import java.util.logging.Logger


/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment : Fragment() {
    var _binding: FragmentTestBinding? = null
    val binding get() = _binding!!
    lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTestBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)


        binding.button.setOnClickListener {
            val str = binding.editTextTextPersonName.text.toString() ?: "hello"
            viewModel.addMessage(str)
            Toast.makeText(context,viewModel.size.toString(),Toast.LENGTH_SHORT).show()
            val action = TestFragmentDirections.actionTestFragmentToSecondFragment(str)
            binding.root.findNavController().navigate(action)
        }

        binding.buttonR.setOnClickListener {
            val str = binding.editTextTextPersonName.text.toString() ?: "hello"
            viewModel.addMessage(str)
            Toast.makeText(context,viewModel.size.toString(),Toast.LENGTH_SHORT).show()
            val action = TestFragmentDirections.actionTestFragmentToRecycleFragment(str)
            binding.root.findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(this.javaClass.name,"finish view")
        _binding = null
    }

}