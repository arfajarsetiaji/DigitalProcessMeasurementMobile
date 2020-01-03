package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {
    private const val NAME = "Digital_Pocess_Measurement_Mobile"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var sharedPreferences: SharedPreferences
    private var IS_NOT_FIRST_RUN_PREF = Pair("is_not_first_run", false)
    private var IS_USER_LOGGED_IN_PREF = Pair("is_user_logged_in", false)
    private var USER_WORK_CENTER_PREF = Pair("user_work_center", "general")
    private var SELECTED_BENEFIT_REPORT_MENU_PREF = Pair("selected_benefit_report_menu", "0")

    fun init(context: Context) { sharedPreferences = context.getSharedPreferences(NAME, MODE) }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var notFirstRun: Boolean
        get() = sharedPreferences.getBoolean(IS_NOT_FIRST_RUN_PREF.first, IS_NOT_FIRST_RUN_PREF.second)
        set(value) = sharedPreferences.edit { it.putBoolean(IS_NOT_FIRST_RUN_PREF.first, value)
        }

    var userLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(IS_USER_LOGGED_IN_PREF.first, IS_USER_LOGGED_IN_PREF.second)
        set(value) = sharedPreferences.edit { it.putBoolean(IS_USER_LOGGED_IN_PREF.first, value)
        }

    var userWorkCenter: String?
        get() = sharedPreferences.getString(USER_WORK_CENTER_PREF.first, USER_WORK_CENTER_PREF.second)
        set(value) = sharedPreferences.edit { it.putString(USER_WORK_CENTER_PREF.first, value)
        }

    var selectedBenefitReportMenu: String?
        get() = sharedPreferences.getString(SELECTED_BENEFIT_REPORT_MENU_PREF.first, SELECTED_BENEFIT_REPORT_MENU_PREF.second)
        set(value) = sharedPreferences.edit { it.putString(USER_WORK_CENTER_PREF.first, value)
        }
}