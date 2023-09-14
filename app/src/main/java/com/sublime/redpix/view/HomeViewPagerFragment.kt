package com.sublime.redpix.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.sublime.redpix.R
import com.sublime.redpix.adapter.COLLECTION_PAGE_INDEX
import com.sublime.redpix.adapter.HomePagerAdapter
import com.sublime.redpix.adapter.IMAGES_PAGE_INDEX
import com.sublime.redpix.databinding.FragmentHomeViewPagerBinding

class HomeViewPagerFragment: Fragment() {

    private lateinit var binding: FragmentHomeViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeViewPagerBinding.inflate(inflater,container,false)

        //Set Viewpager adapter
        setupViewPager()

        //
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()
        return binding.root
    }

    private fun getTabTitle(position: Int): String {
        return when(position) {
            IMAGES_PAGE_INDEX -> getString(R.string.images)
            COLLECTION_PAGE_INDEX -> getString(R.string.my_collection)
            else -> throw IndexOutOfBoundsException()
        }

    }

    private fun getTabIcon(position: Int): Int {
        return when(position) {
            IMAGES_PAGE_INDEX -> R.drawable.images_tab_selector
            COLLECTION_PAGE_INDEX -> R.drawable.collection_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = HomePagerAdapter(this)
    }
}