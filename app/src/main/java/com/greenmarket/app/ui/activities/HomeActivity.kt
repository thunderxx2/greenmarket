package com.greenmarket.app.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.greenmarket.app.R
import com.greenmarket.app.databinding.ActivityHomeBinding
import com.greenmarket.app.ui.fragments.ProductListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity: BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun inflateBinding(inflater: LayoutInflater): ViewBinding {
        binding = ActivityHomeBinding.inflate(inflater)
        return binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fml_fragment, ProductListFragment())
            .commit()
    }

    override fun initializeViews() {
    }

    override fun setupListeners() {
    }
}