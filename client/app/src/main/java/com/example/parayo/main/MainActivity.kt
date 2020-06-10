package com.example.parayo.main

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.parayo.R
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityMainBinding
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

    override fun setupObserver() = Unit

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
    }
}