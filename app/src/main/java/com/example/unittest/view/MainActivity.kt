package com.example.unittest.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.unittest.R
import com.example.unittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.itemIconTintList = null
        initialInit()
        initBottomNavigation()

    }

    private fun initialInit() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, MovieListFragment())
            .commit()
    }

    private fun initBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            replaceFragment(
                when (it.itemId) {
                    R.id.movie_list -> {
                        MovieListFragment()
                    }
                    else -> {
                        MovieStarListFragment()
                    }
                }
            )
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}