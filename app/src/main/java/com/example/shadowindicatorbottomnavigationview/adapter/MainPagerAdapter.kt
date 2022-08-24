package com.example.shadowindicatorbottomnavigationview.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val screens = arrayListOf<Fragment>()

    fun setItems(screens: List<Fragment>) {
        this.screens.apply {
            clear()
            addAll(screens)
            notifyDataSetChanged()
        }
    }

    fun getItems(): List<Fragment> {
        return screens
    }

    override fun getItem(position: Int): Fragment {
        return screens[position]
    }

    override fun getCount(): Int {
        return screens.size
    }
}