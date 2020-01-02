package com.arfajarsetiaji.digitalprocessmeasurementmobile.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import coil.api.load
import coil.transform.CircleCropTransformation
import com.arfajarsetiaji.digitalprocessmeasurementmobile.R
import com.arfajarsetiaji.digitalprocessmeasurementmobile.repository.preferences.AppPreferences
import com.arfajarsetiaji.digitalprocessmeasurementmobile.ui.login.DrawerLocker
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), DrawerLocker {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView: View = navView.getHeaderView(0)
        val imageView: ImageView = headerView.findViewById(R.id.imageView)
        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_dashboard, R.id.nav_data, R.id.nav_report, R.id.nav_change_password, R.id.nav_login), drawerLayout)

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        imageView.load(R.drawable.n219){ crossfade(true).transformations(CircleCropTransformation()) }
        if (!AppPreferences.userLoggedIn){ navController.navigate(R.id.nav_login) } else { navController.navigate(R.id.nav_dashboard) }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun setDrawerLocked(shouldLock: Boolean) {
        if (shouldLock) { drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED) } else { drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) }
    }

    override fun onBackPressed() {
        finishActivityIfCurrentIsNavLogin()
        super.onBackPressed()
    }

    private fun finishActivityIfCurrentIsNavLogin() {
        if (navController.currentDestination?.id  == R.id.nav_login){
            finish()
        }
    }
}
