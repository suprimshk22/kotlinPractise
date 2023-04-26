package com.example.colorapp

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController

class QizViewModel(val initialValue:Int): ViewModel() {

//    var count=initialValue;
//    mutableLiveData value can to changed so used to set value and  as its value can be changed should be private
// liveData value cannot be changed
    private var _count=MutableLiveData<Int>();
    private var _isTen=MutableLiveData<Boolean>()
    val count:LiveData<Int>
    get()=_count
    val isTen:LiveData<Boolean>
    get()=_isTen

    init{
        _isTen.value=false
        Log.i("ViewModel","created!")
        _count.value=initialValue
    }
    fun numberLength(){
        if(count.value!! >10){
            _isTen.value=true
        }
    }
    fun increment(){
//        count++;
         _count.value=(count.value)?.plus(1)?:0
    }
    fun onwin(it: View?) {
        it?.findNavController()?.navigate(R.id.action_quizFragment_to_winFragment)
    }
    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("Destroy","ViewModel Destroyed!")
    }
}