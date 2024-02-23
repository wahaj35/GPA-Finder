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
import android.view.GestureDetector
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.about.databinding.GpaFragmentBinding

@Suppress("DEPRECATION")
class GPAFragment : Fragment() {
    lateinit var binding: GpaFragmentBinding
    lateinit var recyclerView: RecyclerView
   private lateinit var gestureDetector: GestureDetector
    val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.gpa_fragment, container, false)
        binding.apply {
            val subjectsNo = listOf(
                getString(R.string.oneSubject),
                getString(R.string.twoSubjects),
                getString(R.string.threeSubjects),
                getString(R.string.fourSubjects),
                getString(R.string.fiveSubjects),
                getString(R.string.sixSubjects),
                getString(R.string.sevenSubjects),
                getString(R.string.eightSubjects),
                getString(R.string.nineSubjects),
                getString(R.string.tenSubjects)
            )
            val subjects  = listOf("Subject","Subjects")
            val num = arrayOf("1","2","3","4","5","6","7","8","9","10")
             recyclerView = cardRecyclerView
            val adapter = GPAAdapater(subjectsNo, subjects)
            recyclerView.adapter = adapter
            (recyclerView.layoutManager  as GridLayoutManager).spanCount = 2
            adapter.setItemClickListener(object:GPAAdapater.SetOnItemClickListener{
                override fun itemClickListener(position: Int, view: View) {
                    sharedViewModel.noOf_subjects.value = num[position]
                  val cardView =   view.findViewById<CardView>(R.id.cardView)
                    cardView.setCardBackgroundColor(resources.getColor(R.color.hoverColor))
                    view?.findNavController()?.navigate(R.id.action_GPAFrament_to_dataInput)
                }
            })
            return root
        }

    }
}