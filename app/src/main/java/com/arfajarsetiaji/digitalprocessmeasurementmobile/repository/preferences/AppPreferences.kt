package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.preferences

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "Digital_Pocess_Measurement_Mobile"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    private val IS_FIRST_RUN_PREF = Pair("is_first_run", false)
    private val IS_USER_LOGGED_IN_PREF = Pair("is_user_logged_in", false)
    private val USER_WORK_CENTER_PREF = Pair("user_work_center", "general")

    fun init(context: Context) { preferences = context.getSharedPreferences(NAME, MODE)}

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var firstRun: Boolean
        get() = preferences.getBoolean(IS_FIRST_RUN_PREF.first, IS_FIRST_RUN_PREF.second)
        set(value) = preferences.edit { it.putBoolean(IS_FIRST_RUN_PREF.first, value)
        }

    var userLoggedIn: Boolean
        get() = preferences.getBoolean(IS_USER_LOGGED_IN_PREF.first, IS_USER_LOGGED_IN_PREF.second)
        set(value) = preferences.edit { it.putBoolean(IS_USER_LOGGED_IN_PREF.first, value)
        }

    var userWorkCenter: String?
        get() = preferences.getString(USER_WORK_CENTER_PREF.first, USER_WORK_CENTER_PREF.second)
        set(value) = preferences.edit { it.putString(USER_WORK_CENTER_PREF.first, value)
        }
}