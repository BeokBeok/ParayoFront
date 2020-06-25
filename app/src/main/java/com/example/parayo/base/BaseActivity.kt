package com.example.parayo.base

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VDB : ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : AppCompatActivity() {

    protected lateinit var binding: VDB

    abstract fun setupViewModel()
    abstract fun setupObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<VDB>(this, layoutId).apply {
            lifecycleOwner = this@BaseActivity
        }
        setupViewModel()
        setupObserver()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    open fun setupActionBar(title: String?) {
        if (title == null) return
        supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
            this.title = title
            setBackgroundDrawable(
                ColorDrawable(resources.getColor(android.R.color.white, null))
            )
        }
    }
}