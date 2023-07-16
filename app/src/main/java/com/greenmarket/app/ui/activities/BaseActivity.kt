package com.greenmarket.app.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity: AppCompatActivity() {

    private var _binding: ViewBinding? = null
    private val binding: ViewBinding get() = _binding!!

    abstract fun inflateBinding(inflater: LayoutInflater): ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateBinding(layoutInflater)
        setContentView(_binding!!.root)
        initializeViews()
        setupListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun initializeViews()

    abstract fun setupListeners()
}