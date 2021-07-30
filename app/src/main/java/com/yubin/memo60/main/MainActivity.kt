package com.yubin.memo60.main

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yubin.memo60.R
import com.yubin.memo60.BaseActivity
import com.yubin.memo60.databinding.ActivityMainBinding
import com.yubin.memo60.main.home.HomeFilter2Fragment
import com.yubin.memo60.main.home.HomeFilter3Fragment
import com.yubin.memo60.main.home.HomeFragment
import com.yubin.memo60.signin.SignInActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val tabLayout: TabLayout = findViewById(R.id.main_tabs)

        val pagerAdapter = MainPagerAdapter(this)
        pagerAdapter.addFragment(HomeFragment())
        pagerAdapter.addFragment(MemoFragment())
        pagerAdapter.addFragment(SettingFragment())

//        val viewPager: ViewPager2 = findViewById(R.id.main_viewpager)
        binding.mainViewpager.adapter = pagerAdapter

        TabLayoutMediator(binding.mainTabs, binding.mainViewpager){tab, position->
            when(position){
                0-> { tab.icon = getDrawable(R.drawable.round_home_24)
                }
                1-> { tab.icon = getDrawable(R.drawable.outline_add_circle_outline_black_48)
                }
                2-> { tab.icon = getDrawable(R.drawable.round_settings_24)
                }
            }
        }.attach()

    }

    override fun onStart() {
        super.onStart()
    }
    

    //logout 기능
    private fun logout(){
        val spf : SharedPreferences = getSharedPreferences("memoapp", MODE_PRIVATE)
        val editor = spf.edit()
        editor.remove("token")
        editor.apply()
        startSignInActivity()
    }

    private fun startSignInActivity(){
        val intent = Intent(this@MainActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
    }
}