package com.example.databindinghomework.fragment

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.databindinghomework.R
import com.example.databindinghomework.databinding.FragmentABinding
import com.example.databindinghomework.viewmodel.MainViewModel

class FragmentA : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_a,
            container,
            false)
        mainViewModel = MainViewModel(Application())
        return binding.root
    }

    fun setInput(input: String) {
        binding.mainViewModel = mainViewModel.observable
        mainViewModel.setInput(input)
    }
}