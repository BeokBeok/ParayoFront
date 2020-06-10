package com.example.parayo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parayo.auth.AuthActivity
import com.example.parayo.ext.startActivity
import com.example.parayo.main.MainActivity
import com.example.parayo.util.Prefs

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Prefs.token.isNullOrEmpty()) {
            startActivity<AuthActivity>()
        } else {
            startActivity<MainActivity>()
        }
    }
}