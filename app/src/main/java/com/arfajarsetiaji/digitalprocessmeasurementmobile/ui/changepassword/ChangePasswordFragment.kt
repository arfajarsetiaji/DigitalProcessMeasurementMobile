package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.changepassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

class ChangePasswordFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_change_password, container, false)
        val btnConfirm: Button = view.findViewById(R.id.btn_confirm)
        btnConfirm.onClick { toast("Password changed!") }
        return view
    }
}