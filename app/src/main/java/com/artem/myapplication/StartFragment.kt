package com.artem.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.artem.myapplication.databinding.FragmentStartBinding


class StartFragment : Fragment(R.layout.fragment_start) {


    private var _binding: FragmentStartBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners(view)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setListeners(view: View){
        binding.btn3x3.setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_board3x3)
        }
        binding.btn4x4.setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_board4x4)
        }
        binding.btn5x5.setOnClickListener {
            view.findNavController().navigate(R.id.action_startFragment_to_board5x5)
        }
    }


}