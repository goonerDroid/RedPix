package com.sublime.redpix.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sublime.redpix.databinding.FragmentCollectionBinding

class CollectionFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCollectionBinding.inflate(inflater,container,false)
        return binding.root
    }
}
