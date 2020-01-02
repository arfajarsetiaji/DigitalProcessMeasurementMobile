package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import org.jetbrains.anko.sdk27.coroutines.onClick


class LoginFragment : Fragment(), OnBackPressed {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        (activity as DrawerLocker?)!!.setDrawerLocked(true)
        val btnLogin: Button = root.findViewById(R.id.btn_login)
        btnLogin.onClick {findNavController(root).navigate(R.id.action_nav_logout_to_nav_dashboard) }
        return root
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

    override fun onBackPressed() {
        //activity?.supportFragmentManager?.popBackStack()
        activity?.finish()
    }
}