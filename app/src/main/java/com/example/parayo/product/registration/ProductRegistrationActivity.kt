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
        setupActionBar(title = getString(R.string.title_product_registration))
    }

    override fun setupViewModel() = Unit

    override fun setupObserver() = Unit
}