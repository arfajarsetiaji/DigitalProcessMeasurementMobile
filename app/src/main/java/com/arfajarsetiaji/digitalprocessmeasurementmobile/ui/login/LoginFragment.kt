package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R


class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        (activity as DrawerLocker?)!!.setDrawerLocked(true)
        return root
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onDetach() {
        super.onDetach()
        activity?.finish()
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