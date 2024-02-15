package com.example.about

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.about.databinding.FragmentHomeBinding
import android.view.GestureDetector
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var gestureDetector: GestureDetector
    val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {

             lateinit var count: String
            oneSubject.setOnTouchListener { view, event ->
                count = "1"
                oneSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                gestureDetector.onTouchEvent(event)
                true
            }
            twoSubjects.setOnTouchListener { view, event ->
                count = "2"
                twoSubjects.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                gestureDetector.onTouchEvent(event)
                true
            }
            threeSubject.setOnTouchListener { view, event ->
                threeSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                count = "3"
                gestureDetector.onTouchEvent(event)
                true
            }
            fourSubject.setOnTouchListener { view, event ->
                fourSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                count = "4"
                gestureDetector.onTouchEvent(event)
                true
            }
            fiveSubject.setOnTouchListener { view, event ->
                fiveSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                count = "5"
                gestureDetector.onTouchEvent(event)
                true
            }
            sixSubject.setOnTouchListener { view, event ->
                sixSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                count = "6"
                gestureDetector.onTouchEvent(event)
                true
            }
            sevenSubject.setOnTouchListener { view, event ->
                sevenSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                count = "7"
                gestureDetector.onTouchEvent(event)
                true
            }
            eightSubject.setOnTouchListener { view, event ->
                eightSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                count = "8"
                gestureDetector.onTouchEvent(event)
                true
            }
                gestureDetector =
                    GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
                            sharedViewModel.noOf_subjects.value = count
                            view?.findNavController()
                                ?.navigate(R.id.action_homeFragment_to_dataInput)
                            return true
                        }
                    })
            return root
        }

    }

}