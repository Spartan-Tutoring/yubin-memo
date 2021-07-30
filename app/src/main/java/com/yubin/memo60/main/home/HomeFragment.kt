package com.yubin.memo60.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Switch
import androidx.fragment.app.FragmentTransaction
import com.yubin.memo60.BaseFragment
import com.yubin.memo60.R
import com.yubin.memo60.databinding.FragmentHomeBinding

class HomeFragment: BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    var filterNum : Int = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        childFragmentManager.beginTransaction()
            .replace(R.id.home_filter_layout, HomeFilter1Fragment())
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeFilterLl.visibility = GONE

        binding.homeFilterBt.setOnClickListener{
            if (binding.homeFilterLl.visibility == GONE){
                binding.homeFilterLl.visibility = VISIBLE
                binding.homeFilterLl.bringToFront()
            }else{
                binding.homeFilterLl.visibility = GONE
            }
        }

        binding.homeFilter1Tv.setOnClickListener{
            changeFilter(1)
            binding.homeFilterLl.visibility = GONE
        }
        binding.homeFilter2Tv.setOnClickListener{
            changeFilter(2)
            binding.homeFilterLl.visibility = GONE
        }
        binding.homeFilter3Tv.setOnClickListener{
            changeFilter(3)
            binding.homeFilterLl.visibility = GONE
        }
    }

    private fun changeFilter(filterNum : Int) {
        when (filterNum) {
            1 -> childFragmentManager.beginTransaction()
                .replace(R.id.home_filter_layout, HomeFilter1Fragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            2 -> childFragmentManager.beginTransaction()
                .replace(R.id.home_filter_layout, HomeFilter2Fragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            3 -> childFragmentManager.beginTransaction()
                .replace(R.id.home_filter_layout, HomeFilter3Fragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        }
    }
}