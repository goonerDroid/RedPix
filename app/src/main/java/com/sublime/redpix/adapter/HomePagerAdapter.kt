package com.sublime.redpix.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sublime.redpix.view.CollectionFragment
import com.sublime.redpix.view.ImagesFragment

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    /**
     *  Viewpager pages to their respective fragments
     */
    private val fragmentCreator: Map<Int, () -> Fragment> = mapOf(
        IMAGES_PAGE_INDEX to { ImagesFragment() },
        COLLECTION_PAGE_INDEX to { CollectionFragment() }
    )
    override fun getItemCount(): Int {
        return fragmentCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

}

const val IMAGES_PAGE_INDEX = 0
const val COLLECTION_PAGE_INDEX = 1
