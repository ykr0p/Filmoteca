package com.example.filmoteca.ui

import android.content.Context


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
