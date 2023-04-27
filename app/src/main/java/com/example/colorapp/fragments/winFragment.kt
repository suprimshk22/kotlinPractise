package com.example.colorapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.colorapp.R
import com.example.colorapp.databinding.FragmentLoseBinding
import com.example.colorapp.databinding.FragmentWinBinding


class winFragment : Fragment() {
    private var count=0;
    lateinit var inc: TextView;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding= DataBindingUtil.inflate<FragmentWinBinding>(inflater,R.layout.fragment_win, container, false)
        inc=binding.countNum

        setTextCount()

        binding.incrementBtn.setOnClickListener{
            count++;
            setTextCount()
        }


        binding.success.setOnClickListener {
            onReset(it)
        }
        return binding.root
    }
    @SuppressLint("StringFormatMatches")
    private fun setTextCount(){
        val countString = getString(R.string.format_count, count)
        inc.text= countString
    }
    private fun onReset(it: View?) {
        it?.findNavController()?.navigate(R.id.action_winFragment_to_quizFragment)
    }

}

