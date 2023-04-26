package com.example.colorapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.colorapp.R
import com.example.colorapp.databinding.FragmentLoseBinding
import com.example.colorapp.databinding.FragmentWinBinding


class winFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding= DataBindingUtil.inflate<FragmentWinBinding>(inflater,R.layout.fragment_win, container, false)
        binding.success.setOnClickListener {
            onReset(it)
        }
        return binding.root
    }

    private fun onReset(it: View?) {
        it?.findNavController()?.navigate(R.id.action_winFragment_to_quizFragment)
    }

}

