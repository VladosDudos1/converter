package com.example.currencyconverter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.currencyconverter.R
import com.example.currencyconverter.fragments.ConverterFragment
import com.example.currencyconverter.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openConverterFragment()


        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigatin_bar)

        bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when (item.itemId){

                R.id.converter -> {
                    openConverterFragment()
                }
                R.id.settings -> {
                    openSettingsFragment()
                }
            }
            true
        }
    }

    fun changeFragment(fmt: Fragment){
        manager.beginTransaction().replace(R.id.fragment_holder, fmt).addToBackStack(null).commit()
    }

    fun openConverterFragment(){
        changeFragment(ConverterFragment())
        }

    fun openSettingsFragment(){
        changeFragment(SettingsFragment())
    }

    override fun onRestart() {
        super.onRestart()
        openConverterFragment()
    }

    override fun onBackPressed() {
        if (manager.backStackEntryCount > 0) {
            val count = manager.backStackEntryCount
            for (i in 0 until count) manager.popBackStack()
            manager.beginTransaction().replace(
                R.id.fragment_holder, ConverterFragment()).commit()
        }
        else {
            super.onBackPressed()
        }

    }
}
