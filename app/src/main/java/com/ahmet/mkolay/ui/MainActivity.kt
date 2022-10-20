package com.ahmet.mkolay.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ahmet.mkolay.R
import com.ahmet.mkolay.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: Fragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)!!
        navController = (navHostFragment as NavHostFragment).navController

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.anasayfaFragment -> {
                    navController.navigate(R.id.anasayfaFragment)
                    true
                }

                R.id.migroskopFragment -> {
                    navController.navigate(R.id.migroskopFragment)
                    true
                }
                R.id.migrostvFragment -> {
                    navController.navigate(R.id.migrostvFragment)
                    true
                }
                R.id.MKolayyFragment -> {
                    navController.navigate(R.id.MKolayyFragment)
                    true
                }
                R.id.profilFragment -> {
                    navController.navigate(R.id.profilFragment)
                    true
                }
                else -> {
                    navController.navigate(R.id.MKolayyFragment)
                    true
                }
            }
        }


     /*   val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))

      */

    }
    override fun onBackPressed() {
        when(NavHostFragment.findNavController(navHostFragment).currentDestination!!.id) {
            R.id.anasayfaFragment -> {
                navController.navigate(R.id.MKolayyFragment)
                binding.bottomNavigationView.checkItem(R.id.MKolayyFragment)
            }
            R.id.migroskopFragment -> {
                navController!!.navigate(R.id.MKolayyFragment)
                binding.bottomNavigationView.checkItem(R.id.MKolayyFragment)
            }
            R.id.migrostvFragment -> {
                navController!!.navigate(R.id.MKolayyFragment)
                binding.bottomNavigationView.checkItem(R.id.MKolayyFragment)
            }
            R.id.profilFragment -> {
                navController!!.navigate(R.id.MKolayyFragment)
                binding.bottomNavigationView.checkItem(R.id.MKolayyFragment)
            }
            R.id.MKolayyFragment -> {
                this.finish()
            }
        }
    }

    fun BottomNavigationView.checkItem(actionId: Int) {
        menu.findItem(actionId)?.isChecked = true
    }
}