package com.artem.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.artem.myapplication.databinding.FragmentBoard3x3Binding
import com.artem.myapplication.databinding.FragmentScoresBinding


class ScoresFragment : Fragment() {
    private var _binding: FragmentScoresBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentScoresBinding.inflate(inflater, container, false)
        val view = binding.root
        getScores()
        return view
    }

    override fun onResume() {
        getScores()
        super.onResume()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getScores(){
       /* val scoresNavalny=args.scoreNavalny
        val scoresPutin=args.scorePutin*/
        val args= this.arguments
        val scoresNavalny=args?.get("scoreNavalny")
        val scoresPutin=args?.get("scorePutin")
        binding.txtScoresPutin.text=scoresPutin.toString()
        binding.txtScoresNavalny.text=scoresNavalny.toString()
    }

}