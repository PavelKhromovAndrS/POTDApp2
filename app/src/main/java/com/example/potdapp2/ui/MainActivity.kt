package com.example.potdapp2.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.potdapp2.R
import com.example.potdapp2.ui.screens.epic.EpicFragment
import com.example.potdapp2.ui.screens.potd.MainFragment
import com.example.potdapp2.ui.screens.settings.SettingsFragment
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
                    navigationTo(MainFragment())
                    true
                }
                R.id.settings_menu -> {
                    navigationTo(SettingsFragment())
                    true
                }
                R.id.epic_menu -> {
                    navigationTo(EpicFragment())
                    true
                }

                else -> true
            }
        }
    }

    private fun navigationTo(f: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, f)
            .addToBackStack(null)
            .commit()
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

