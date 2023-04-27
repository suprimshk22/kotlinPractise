package com.example.colorapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuizViewModelFactory(val initialCount:Int):ViewModelProvider.Factory {
    /**
     * Creates a new instance of the given `Class`.
     *
     * Default implementation throws [UnsupportedOperationException].
     *
     * @param modelClass a `Class` whose instance is requested
     * @return a newly created ViewModel
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QizViewModel(initialCount) as T
    }
}