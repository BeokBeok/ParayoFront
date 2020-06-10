package com.example.parayo.util

import androidx.preference.PreferenceManager
import com.example.parayo.ParayoApplication
import com.example.parayo.auth.model.AuthModel

object Prefs {

    private const val TOKEN = "token"
    private const val REFRESH_TOKEN = "refresh_token"
    private const val USER_NAME = "user_name"
    private const val USER_ID = "user_id"

    private val prefs by lazy {
        PreferenceManager.getDefaultSharedPreferences(ParayoApplication.instance)
    }

    var token
        get() = prefs.getString(TOKEN, "")
        set(value) = prefs.edit().putString(TOKEN, value ?: "").apply()

    private var refreshToken
        get() = prefs.getString(REFRESH_TOKEN, "")
        set(value) = prefs.edit().putString(REFRESH_TOKEN, value ?: "").apply()

    private var userName
        get() = prefs.getString(USER_NAME, "")
        set(value) = prefs.edit().putString(USER_NAME, value ?: "").apply()

    private var userId
        get() = prefs.getLong(USER_ID, -1L)
        set(value) = prefs.edit().putLong(USER_ID, value).apply()

    fun saveAuth(auth: AuthModel) {
        auth.run {
            Prefs.token = token
            Prefs.refreshToken = refreshToken
            Prefs.userName = userName
            Prefs.userId = userId
        }
    }
}