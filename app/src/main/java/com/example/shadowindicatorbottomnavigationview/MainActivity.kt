package com.example.shadowindicatorbottomnavigationview

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.shadowindicatorbottomnavigationview.adapter.MainPagerAdapter
import com.example.shadowindicatorbottomnavigationview.fragment.HomeFragment
import com.shadowindicatorbottomnavigationview.ShadowIndicatorBottomNavigationView


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: ShadowIndicatorBottomNavigationView
    private lateinit var mainPagerAdapter: MainPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)

        // Set items to be displayed.
        mainPagerAdapter.setItems(
            arrayListOf(
                HomeFragment(R.string.home),
                HomeFragment(R.string.phone),
                HomeFragment(R.string.settings),
                HomeFragment(R.string.star),
                HomeFragment(R.string.user)
            )
        )

        // Show the default screen.
        val defaultScreen = 0
        scrollToScreen(defaultScreen)
//        selectBottomNavigationViewMenuItem(defaultScreen.menuItemId)
//        supportActionBar?.setTitle(defaultScreen.titleStringId)

        // Set the listener for item selection in the bottom navigation view.
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
//        bottomNavigationView.isItemHorizontalTranslationEnabled = true

        // Attach an adapter to the view pager and make it select the bottom navigation
        // menu item and change the title to proper values when selected.
        viewPager.adapter = mainPagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                selectBottomNavigationViewMenuItem(bottomNavigationView.menu[position].itemId)
//                supportActionBar?.setTitle(selectedScreen.titleStringId)
            }
        })
    }

    /**
     * Scrolls `ViewPager` to show the provided screen.
     */
    private fun scrollToScreen(index: Int) {
        val screenPosition = index
        if (screenPosition != viewPager.currentItem) {
            viewPager.currentItem = screenPosition
        }
    }

    /**
     * Selects the specified item in the bottom navigation view.
     */
    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
//        bottomNavigationView.setOnNavigationItemSelectedListener(null)
        bottomNavigationView.selectedItemId = menuItemId
//        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    /**
     * Listener implementation for registering bottom navigation clicks.
     */
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.item1 -> {
                scrollToScreen(0)
            }

            R.id.item2 -> {
                scrollToScreen(1)
            }

            R.id.item3 -> {
                scrollToScreen(2)
            }

            R.id.item4 -> {
                scrollToScreen(3)
            }

            R.id.item5 -> {
                scrollToScreen(4)
            }

        }

//        getMainScreenForMenuItem(menuItem.itemId)?.let {
//            scrollToScreen(it)
//            supportActionBar?.setTitle(it.titleStringId)
//            return true
//        }
        return true
    }

}