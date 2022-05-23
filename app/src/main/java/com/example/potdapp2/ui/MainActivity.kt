package com.example.potdapp2.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.potdapp2.R
import com.google.android.material.bottomnavigation.BottomNavigationView

const val ThemeOne = 1
const val ThemeSecond = 2
const val API_KEY = "IUVdvJcQ84afIE5PldFC208UfJF9L8P0DqCSqByj"
const val BASE_URL = "https://api.nasa.gov/"

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val KEY_SP = "sp"
    private val KEY_CURRENT_THEME = "current_theme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(getRealStyle(getCurrentTheme()))

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.picture_of_the_day_menu -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_settingsFragment_to_mainFragment)
                    true
                }
                R.id.settings_menu -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_settingsFragment)
                    true
                }
                R.id.epic_menu -> {
                    findNavController(R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_epicFragment)
                    true
                }

                else -> true
            }
        }
    }

    fun setCurrentTheme(currentTheme: Int) {
        val sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_CURRENT_THEME, currentTheme)
        editor.apply()
    }

    fun getCurrentTheme(): Int {
        val sharedPreferences = getSharedPreferences(KEY_SP, MODE_PRIVATE)
        return sharedPreferences.getInt(KEY_CURRENT_THEME, -1)
    }

    private fun getRealStyle(currentTheme: Int): Int {
        return when (currentTheme) {
            ThemeOne -> R.style.ThemeOne
            ThemeSecond -> R.style.ThemeSecond
            else -> 0
        }
    }
}

