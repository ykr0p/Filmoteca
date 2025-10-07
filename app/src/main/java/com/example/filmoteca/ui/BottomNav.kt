package com.example.filmoteca.ui

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.filmoteca.R

import nl.joery.animatedbottombar.AnimatedBottomBar


fun setupBottomNav(bottomBar: AnimatedBottomBar, context: Context) {
    bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
        override fun onTabSelected(
            lastIndex: Int,
            lastTab: AnimatedBottomBar.Tab?,
            newIndex: Int,
            newTab: AnimatedBottomBar.Tab
        ) {

        }
    })
}
