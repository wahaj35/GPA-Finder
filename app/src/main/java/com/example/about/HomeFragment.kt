package com.example.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.about.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
//        binding.oneSubject.setOnClickListener{view:View -> Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_reportFragment)}
        return binding.root
    }
}