package com.example.filmoteca.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.filmoteca.R


import nl.joery.animatedbottombar.AnimatedBottomBar


fun setupBottomNav(bottomBar: AnimatedBottomBar, activity: AppCompatActivity) {
    bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
        override fun onTabSelected(
            lastIndex: Int,
            lastTab: AnimatedBottomBar.Tab?,
            newIndex: Int,
            newTab: AnimatedBottomBar.Tab
        ) {
            val fragment = when (newTab.id) {
                R.id.home -> HomeFragment()
                R.id.explore -> ExploreFragment()
                R.id.profile -> ProfileFragment()
                else -> return
            }

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.mainActFrameLayout, fragment)
                .commit()
        }
    })
}
