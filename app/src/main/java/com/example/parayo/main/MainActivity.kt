package com.example.parayo.main

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.Observer
import com.example.parayo.R
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityMainBinding
import com.example.parayo.ext.showToast
import com.example.parayo.ext.startActivity
import com.example.parayo.product.registration.ProductRegistrationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutId = R.layout.activity_main
) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
        setupDrawer()
    }

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun setupObserver() {
        viewModel.productRegistration.observe(this, Observer {
            startActivity<ProductRegistrationActivity>()
        })
    }

    private fun setupToolbar() {
        binding.tbMainToolbar.run {
            menu.add("Search")
                .setIcon(R.drawable.ic_baseline_search_24)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        }
    }

    private fun setupDrawer() {
        val drawerToggle = ActionBarDrawerToggle(
            this,
            binding.dlMainDrawer,
            binding.tbMainToolbar,
            R.string.open_drawer_description,
            R.string.close_drawer_description
        )
        binding.dlMainDrawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        binding.nvMainNaviView.setNavigationItemSelectedListener { menuItem ->
            binding.dlMainDrawer.closeDrawers()

            when (menuItem.itemId) {
                R.id.menu_my_inquiry -> showToast("내 문의")
                R.id.menu_logout -> showToast("로그아웃")
            }
            menuItem.isChecked = false
            return@setNavigationItemSelectedListener true
        }
    }
}