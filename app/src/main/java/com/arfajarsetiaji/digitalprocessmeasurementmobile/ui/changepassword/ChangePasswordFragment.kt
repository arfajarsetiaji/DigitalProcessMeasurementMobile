package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.changepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R

class ChangePasswordFragment : Fragment() {
    private lateinit var changePasswordViewModel: ChangePasswordViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        changePasswordViewModel = ViewModelProviders.of(this).get(ChangePasswordViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_change_password, container, false)
        val textView: TextView = root.findViewById(R.id.text_share)
        changePasswordViewModel.text.observe(this, Observer {textView.text = it })
        return root
    }
}