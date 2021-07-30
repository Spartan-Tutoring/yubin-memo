package com.yubin.memo60.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.yubin.memo60.BaseFragment
import com.yubin.memo60.R
import com.yubin.memo60.databinding.FragmentHomeFilter3Binding

class HomeFilter3Fragment: BaseFragment() {
    private lateinit var binding: FragmentHomeFilter3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeFilter3Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//        binding.homeFilterBt.setOnClickListener{
//            if (binding.homeFilterLl.visibility == View.GONE){
//                binding.homeFilterLl.visibility = View.VISIBLE
//                binding.homeFilterLl.bringToFront()
//            }else{
//                binding.homeFilterLl.visibility = View.GONE
//            }
//        }
//
//        binding.homeFilter1Tv.setOnClickListener{
//            changeFilter(1)
//        }
//        binding.homeFilter2Tv.setOnClickListener{
//            changeFilter(2)
//        }
    }

    private fun changeFilter(filterNum : Int){
        when (filterNum) {
            1 -> childFragmentManager.beginTransaction()
                .replace(R.id.home_filter3_ll, HomeFragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            2 -> childFragmentManager.beginTransaction()
                .replace(R.id.home_filter3_ll, HomeFilter2Fragment())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
        }
    }
}