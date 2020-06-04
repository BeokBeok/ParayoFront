package com.example.parayo

import android.os.Bundle
import androidx.activity.viewModels
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main
) {
    private val viewModel by viewModels<MainViewModel>()

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showContents()
    }

    private fun showContents() {
        viewModel.getHello()
    }
}