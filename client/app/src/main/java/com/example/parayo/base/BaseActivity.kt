package com.example.parayo.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VDB : ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    protected lateinit var binding: VDB

    open fun setupViewModel() = Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<VDB>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
        }
        setupViewModel()
    }
}