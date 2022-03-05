package com.example.movieinfo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.movieinfo.R
import com.example.movieinfo.adapter.PagerAdapter
import com.example.movieinfo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.itemIconTintList = null
        initPagerAdapter()
        initPager()
        initBottomNavigation()
    }

    private fun initPagerAdapter() {
        binding.mainViewPager.adapter =
            PagerAdapter(this, arrayListOf(MovieListFragment(), MovieStarListFragment()))
    }

    private fun initPager() {
        binding.apply {
            mainViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    bottomNavigation.menu.getItem(position).isChecked = true
                }
            })
        }
    }

    private fun initBottomNavigation() {
        binding.apply {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.movie_list -> {
                        mainViewPager.currentItem = 0
                    }
                    else -> {
                        mainViewPager.currentItem = 1
                    }
                }
                true
            }
        }
    }

}