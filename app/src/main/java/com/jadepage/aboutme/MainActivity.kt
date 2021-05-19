package com.jadepage.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.jadepage.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            handleBottomNavigation(it.itemId, binding)
        }

        binding.bottomNavigation.selectedItemId = R.id.menu_home
    }

    private fun handleBottomNavigation(
            menuItemId: Int,
            binding: ActivityMainBinding
    ) : Boolean = when(menuItemId) {
            R.id.menu_home -> {
                swapFragments(HomeFragment())
                true
            }
            R.id.menu_about_me -> {
                swapFragments(AboutMeFragment())
                true
            }
            R.id.menu_family -> {
                swapFragments(FamilyFragment())
                true
            }
            R.id.menu_hobbies -> {
                swapFragments(HobbiesFragment())
                true
            }
            else -> false
        }

    private fun swapFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment).commit()
    }
}