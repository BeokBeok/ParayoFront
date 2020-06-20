package com.example.parayo.auth

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.parayo.R
import com.example.parayo.base.BaseActivity
import com.example.parayo.databinding.ActivityAuthBinding
import com.example.parayo.ext.showToast
import com.example.parayo.ext.startActivity
import com.example.parayo.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : BaseActivity<ActivityAuthBinding>(
    layoutId = R.layout.activity_auth
) {
    private val viewModel by viewModels<AuthViewModel>()

    override fun setupViewModel() {
        binding.vm = viewModel
    }

    override fun setupObserver() {
        viewModel.run {
            throwable.observe(this@AuthActivity, Observer {
                try {
                    val stringRes = it.message?.toInt() ?: -1
                    if (stringRes == -1) return@Observer
                    showToast(getString(stringRes))
                } catch (e: NumberFormatException) {
                    showToast(it.message ?: "")
                }
            })
            successLogin.observe(this@AuthActivity, Observer {
                if (it) {
                    showToast(getString(R.string.msg_success_login))
                    startActivity<MainActivity>()
                }
            })
        }
    }
}