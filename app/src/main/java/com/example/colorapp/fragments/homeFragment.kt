package com.example.colorapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.colorapp.R
import com.example.colorapp.databinding.FragmentHomeBinding


class homeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
        binding.play.setOnClickListener {
           playQuiz(it)
        }
        setMenuVisibility(true)
        return binding.root
    }



    private fun playQuiz(it:View) {
        it.findNavController().navigate(R.id.action_homeFragment2_to_quizFragment)
    }


}