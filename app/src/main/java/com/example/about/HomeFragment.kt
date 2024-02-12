package com.example.about

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.about.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
//        binding.oneSubject.setOnClickListener{view:View -> Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_reportFragment)}
        val textView = binding.oneSubject

        Toast.makeText(context,"Choose no.Of Subjects", Toast.LENGTH_LONG).show()

        // Set up touch listener (optional)
        textView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    // Touch down
                    textView.setBackgroundColor(resources.getColor(R.color.hoverColor))
                }
                MotionEvent.ACTION_UP -> {
                    // Touch released
                    textView.setBackgroundColor(resources.getColor(com.google.android.material.R.color.androidx_core_secondary_text_default_material_light))
                    view?.findNavController()?.navigate(R.id.action_homeFragment_to_aboutFragment)
                }
            }
            true
        }

        return binding.root
    }
}