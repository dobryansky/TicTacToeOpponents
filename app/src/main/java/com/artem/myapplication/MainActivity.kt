package com.artem.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val bottomNavigationView =findViewById<BottomNavigationView>(R.id.bottomNavView)

        val  navController=findNavController(R.id.fragmentContainerView)

        bottomNavigationView.setupWithNavController(navController)
        /*val appBarConfiguration= AppBarConfiguration(setOf(R.id.fragmentSettings))
        setupActionBarWithNavController(navController,appBarConfiguration)*/
    }
}