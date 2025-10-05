package com.example.filmoteca.ui

import android.content.Context
import android.widget.Toast
import nl.joery.animatedbottombar.AnimatedBottomBar

fun setupBottomNav(bottomBar: AnimatedBottomBar, context: Context) {
    bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
        override fun onTabSelected(
            lastIndex: Int,
            lastTab: AnimatedBottomBar.Tab?,
            newIndex: Int,
            newTab: AnimatedBottomBar.Tab
        ) {
            Toast.makeText(context, "Selected: ${newTab.title}", Toast.LENGTH_SHORT).show()
        }

        override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {
            Toast.makeText(context, "Reselected: ${tab.title}", Toast.LENGTH_SHORT).show()
        }
    })
}
