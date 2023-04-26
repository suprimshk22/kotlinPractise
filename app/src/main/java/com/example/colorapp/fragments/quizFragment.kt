package com.example.colorapp.fragments

import android.icu.number.Precision.increment
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.colorapp.QizViewModel
import com.example.colorapp.QuizViewModelFactory
import com.example.colorapp.R
import com.example.colorapp.databinding.FragmentHomeBinding
import com.example.colorapp.databinding.FragmentQuizBinding



class quizFragment : Fragment() {
private var  count=0;
private lateinit var inc:TextView;
    private lateinit var quizViewModel:QizViewModel;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("quiz","$count")
        val binding =DataBindingUtil.inflate<FragmentQuizBinding>(inflater,R.layout.fragment_quiz,container,false)

//        initializing view model
//        here, QuizViewModelfactory is to pass parameter to view model .

        quizViewModel=ViewModelProvider(this,QuizViewModelFactory(5)).get(QizViewModel::class.java)
//        connecting with xml (ui controller)
        binding.quizModel=quizViewModel
        //        used for observing changes of LiveData in this binding.
        binding.setLifecycleOwner(this)
        Log.i("ViewModel","called...")
//        quizViewModel.count.value="mutable live data so value cannot be set"
//        ui controller observing changes in view model and set data as per change.
//        quizViewModel.count.observe(viewLifecycleOwner,Observer{
//            binding.countNum.text=it.toString()
//        })
//        quizViewModel.isTen.observe(viewLifecycleOwner,Observer{isGreaterTen->
//            Log.d("great","$isGreaterTen")
//
//            if(isGreaterTen){
//             Log.d("great","$isGreaterTen")
//             binding.incrementBtn.isEnabled=false
//         }
//        })
//        setTextCount()
     binding.incrementBtn.setOnClickListener {
         incrementCount()
//         setTextCount( )
     }
//        binding.over.setOnClickListener{
//            onOver(it)
//        }
        binding.win.setOnClickListener{
            onwin(it)
        }
        return binding.root
    }

    private fun incrementCount() {
//        count++
   quizViewModel.increment()
        quizViewModel.numberLength()
    }
//    private fun setTextCount(){
////        inc.text= count.toString()
//        inc.text=quizViewModel.count.toString()
//    }

     fun onwin(it: View?) {
it?.findNavController()?.navigate(R.id.action_quizFragment_to_winFragment)
    }

    private fun onOver(it:View?) {
it?.findNavController()?.navigate(R.id.action_quizFragment_to_loseFragment)
    }

}