package com.example.secondapp_johnpaultgonzales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.secondapp_johnpaultgonzales.databinding.ActivityMainScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class mainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(LowClassVehicles())

        binding.bottomNavBar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.lowclass -> replaceFragment(LowClassVehicles())
                R.id.midclass -> replaceFragment(MidClassVehicles())
                R.id.highclass -> replaceFragment(High_Class_Vehicles())
                R.id.profile -> replaceFragment(Profile_screen())
                else ->{

                }
            }
            true
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Layout, fragment)
        fragmentTransaction.commit()
    }
}
