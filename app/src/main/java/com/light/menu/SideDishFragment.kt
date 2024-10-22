package com.light.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class SideDishFragment : Fragment() {
    private lateinit var orderViewModel: OrderViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_side_dish, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val sideDish1 = view.findViewById<CheckBox>(R.id.sideDish1)
        sideDish1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.salad1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.salad1))
            }
        }
        val sideDish2 = view.findViewById<CheckBox>(R.id.sideDish2)
        sideDish2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.salad2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.salad2))
            }
        }
        val sideDish3 = view.findViewById<CheckBox>(R.id.sideDish3)
        sideDish3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.salad3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.salad3))
            }
        }
        val sideDish4 = view.findViewById<CheckBox>(R.id.sideDish4)
        sideDish4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.soup1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.soup1))
            }
        }
        val sideDish5 = view.findViewById<CheckBox>(R.id.sideDish5)
        sideDish5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.soup2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.soup2))
            }
        }
        val sideDish6 = view.findViewById<CheckBox>(R.id.sideDish6)
        sideDish6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.soup3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.soup3))
            }
        }
        val nextButton = view.findViewById<Button>(R.id.nextBtn)
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.sideDish_to_dessertFragment)
        }
        val prevButton = view.findViewById<Button>(R.id.previousBtn)
        prevButton.setOnClickListener {
            findNavController().navigate(R.id.sideDish_to_mainDishFragment)
        }
        return view
    }
}