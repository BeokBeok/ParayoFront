package com.example.parayo.product.registration

import android.os.Bundle
import com.example.parayo.R
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityProductRegistrationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductRegistrationActivity : BaseActivity<ActivityProductRegistrationBinding>(
    layoutId = R.layout.activity_product_registration
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
    }

    override fun setupViewModel() = Unit

    override fun setupObserver() = Unit

    private fun setupToolbar() {
        binding.tbProductRegistration.run {
            setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
            setOnClickListener { finish() }
        }
    }
}