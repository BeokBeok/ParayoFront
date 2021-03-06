package com.example.parayo.product.registration

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.parayo.R
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityProductRegistrationBinding
import com.example.parayo.wrapper.BeokGlide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductRegistrationActivity : BaseActivity<ActivityProductRegistrationBinding>(
    layoutId = R.layout.activity_product_registration
) {

    private val viewModel by viewModels<ProductRegistrationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBar(title = getString(R.string.title_product_registration))
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun setupObserver() {
        for (index in viewModel.imageUris.indices) {
            viewModel.imageUris[index].observe(this, Observer {
                BeokGlide.srcWithGlide(
                    imageView = when (index) {
                        1 -> binding.ivProductRegistrationTwo
                        2 -> binding.ivProductRegistrationThree
                        3 -> binding.ivProductRegistrationFour
                        else -> binding.ivProductRegistrationOne
                    },
                    uri = it
                )
            })
        }
        viewModel.categories.observe(this, Observer {
            binding.spinProductRegistrationCategory.adapter = ArrayAdapter(
                this@ProductRegistrationActivity,
                android.R.layout.simple_spinner_dropdown_item,
                it
            )
            binding.spinProductRegistrationCategory.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) = Unit

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        viewModel.onCategorySelect(position)
                    }
                }
        })
    }
}