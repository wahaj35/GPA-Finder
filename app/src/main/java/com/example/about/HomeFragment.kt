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
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.about.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
lateinit var binding: FragmentHomeBinding
 val sharedViewModel:SharedViewModel by activityViewModels()
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.apply {
            val cardViews = arrayOf(
                oneSubject,
                twoSubjects,
                threeSubject,
                fourSubject,
                fiveSubject,
                sixSubject,
                sevenSubject,
                eightSubject
            )
            Toast.makeText(context, "Choose no.Of Subjects", Toast.LENGTH_SHORT).show()

            // Set up touch listener (optional)
            for(i in cardViews.indices){
                cardViews[i].setOnTouchListener { v, event ->
                    when (event.action) {
                        MotionEvent.ACTION_DOWN -> {
                            // Touch down
                            cardViews[i].setBackgroundColor(resources.getColor(R.color.hoverColor))
                        }

                        MotionEvent.ACTION_UP -> {
                            // Touch released
                            cardViews[i].setBackgroundColor(resources.getColor(com.google.android.material.R.color.androidx_core_secondary_text_default_material_light))
                            if(cardViews[i] == oneSubject){
                                sharedViewModel.noOf_subjects.value = "1"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            } else if (cardViews[i] == twoSubjects)
                            {
                                sharedViewModel.noOf_subjects.value = "2"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                            else if (cardViews[i] == threeSubject)
                            {
                                sharedViewModel.noOf_subjects.value = "3"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                            else if (cardViews[i] == fourSubject)
                            {
                                sharedViewModel.noOf_subjects.value = "4"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                            else if (cardViews[i] == fiveSubject)
                            {
                                sharedViewModel.noOf_subjects.value = "5"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                            else if (cardViews[i] == sixSubject)
                            {
                                sharedViewModel.noOf_subjects.value = "6"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                            else if (cardViews[i] == sevenSubject)
                            {
                                sharedViewModel.noOf_subjects.value = "7"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                            else if (cardViews[i] == eightSubject)
                            {
                                sharedViewModel.noOf_subjects.value = "8"
                                view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                            }
                        }
                    }
                    true
                }
            }


            return binding.root
        }
    }
}