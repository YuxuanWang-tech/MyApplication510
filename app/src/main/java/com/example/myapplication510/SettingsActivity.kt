package com.example.myapplication510

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication510.SettingsFragment

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settingslayout, SettingsFragment())
            .commit()
    }
}
