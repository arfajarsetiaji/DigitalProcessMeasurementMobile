package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.AppPreferences
import com.google.android.material.textfield.TextInputEditText
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast


class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        (activity as DrawerLocker?)!!.setDrawerLocked(true)
        val btnLogin: Button = root.findViewById(R.id.btn_login)
        val tietUsername: TextInputEditText = root.findViewById(R.id.tiet_username)
        val tietPassword: TextInputEditText = root.findViewById(R.id.tiet_password)
        btnLogin.onClick {
            when(tietUsername.text.toString()){
                "sheetmetal" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "sheetmetal"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                    }
                "machining" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "machining"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                }
                "surface" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "surface"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                }
                "painting" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "painting"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                }
                "hardnessline" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "hardnessline"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                    }
                "penetrantline" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "penetrantline"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                }
                "finaldpm" ->
                    if (tietPassword.text.toString() == tietUsername.text.toString()) {
                        AppPreferences.userWorkCenter = "finaldpm"
                        AppPreferences.userLoggedIn = true
                        AppPreferences.notFirstRun = true
                        findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard)
                }
            }
        }
        return root
    }

    override fun onAttach(context: Context) {
        AppPreferences.userLoggedIn = false
        if (AppPreferences.notFirstRun) { toast(getString(R.string.message_logout)) }
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onDestroyView() {
        (activity as DrawerLocker?)!!.setDrawerLocked(false)
        super.onDestroyView()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

}