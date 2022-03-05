package com.example.movieinfo.adapter

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(
    activity: AppCompatActivity,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(activity) {

//    override fun getItemCount(): Int = fragments.size
//
//    override fun createFragment(position: Int): Fragment = fragments[position]

    override fun getItemCount(): Int {
        Log.d("nkh", "getItemCount : ${fragments.size}")
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        Log.d("nkh", "createFragment : ${fragments[position]}")
        return fragments[position]
    }

}