package com.example.databindinghomework.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.databindinghomework.R
import com.example.databindinghomework.databinding.ActivityMainBinding
import com.example.databindinghomework.fragment.FragmentA
import com.example.databindinghomework.fragment.FragmentB
import com.example.databindinghomework.fragment.FragmentC
import com.example.databindinghomework.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    val fragmentA = FragmentA()
    val fragmentB = FragmentB()
    val fragmentC = FragmentC()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.framelayout_a, fragmentA).commit()
        supportFragmentManager.beginTransaction().replace(R.id.framelayout_b, fragmentB).commit()
        supportFragmentManager.beginTransaction().replace(R.id.framelayout_c, fragmentC).commit()



        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.mainViewModel = mainViewModel.observable

        edittext_input.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(editable: Editable?) {
                mainViewModel.setInput(editable.toString())
                fragmentA.setInput(editable.toString())
                fragmentB.setInput(editable.toString())
                fragmentC.setInput(editable.toString())

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

    }
}
