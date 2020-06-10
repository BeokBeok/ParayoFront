package com.example.parayo.main

import androidx.activity.viewModels
import com.example.parayo.R
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main
) {

    private val viewModel by viewModels<MainViewModel>()

    override fun setupObserver() = Unit
}