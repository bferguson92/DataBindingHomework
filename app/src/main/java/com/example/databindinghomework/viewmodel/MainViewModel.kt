package com.example.databindinghomework.viewmodel

import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val observable = ViewObserable()

    fun setInput(newInput: String) {
        observable.apply {
            input = newInput
        }
    }

    inner class ViewObserable : BaseObservable(){
        @get: Bindable
        var  input: String = ""
        set(input) {
            field = input
            notifyPropertyChanged(BR.input)
        }

    }
}