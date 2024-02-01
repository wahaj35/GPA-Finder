package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.about.databinding.FragmentDataInputBinding
import com.example.about.databinding.FragmentReportBinding


class Report : Fragment() {
    lateinit var binding: FragmentReportBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_report, container,false)
        return binding.root
    }

}