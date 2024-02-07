package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.about.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
lateinit var binding : FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_about,container,false)
        return binding.root
    }

}