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
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var recyclerView: RecyclerView
   private lateinit var gestureDetector: GestureDetector
    val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.apply {

             lateinit var count: String
            val subjects = listOf(
                getString(R.string.oneSubject),
                getString(R.string.twoSubjects),
                getString(R.string.threeSubjects),
                getString(R.string.fourSubjects),
                getString(R.string.fiveSubjects),
                getString(R.string.sixSubjects),
                getString(R.string.sevenSubjects),
                getString(R.string.eightSubjects),
            )
            val num = arrayOf("1","2","3","4","5","6","7","8")
             recyclerView = cardRecyclerView
            val adapter = HomeItemsAdapter(subjects)
            recyclerView.adapter = adapter
            (recyclerView.layoutManager  as GridLayoutManager).spanCount = 2
            adapter.setItemClickListener(object:HomeItemsAdapter.SetOnItemClickListener{
                override fun itemClickListener(position: Int, view: View) {
//                   if(position == 0) count = "1"
//                   else if(position == 1) count = "2"
//                   else if(position == 2) count = "3"
//                   else if(position == 3) count = "4"
//                   else if(position == 4) count = "5"
//                   else if(position == 5) count = "6"
//                   else if(position == 6) count = "7"
//                   else if(position == 7) count = "8"
                    sharedViewModel.noOf_subjects.value = num[position]
                    view?.findNavController()?.navigate(R.id.action_homeFragment_to_dataInput)
                }
            })
//            oneSubject.setOnTouchListener { _, event ->
//                count = "1"
//                oneSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            twoSubjects.setOnTouchListener { _, event ->
//                count = "2"
//                twoSubjects.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            threeSubject.setOnTouchListener { _, event ->
//                threeSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                count = "3"
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            fourSubject.setOnTouchListener { _, event ->
//                fourSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                count = "4"
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            fiveSubject.setOnTouchListener { _, event ->
//                fiveSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                count = "5"
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            sixSubject.setOnTouchListener { _, event ->
//                sixSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                count = "6"
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            sevenSubject.setOnTouchListener { _, event ->
//                sevenSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                count = "7"
//                gestureDetector.onTouchEvent(event)
//                true
//            }
//            eightSubject.setOnTouchListener { _, event ->
//                eightSubject.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
//                count = "8"
//                gestureDetector.onTouchEvent(event)
//                true
//            }
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