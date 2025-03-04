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
    ): View {
        val view = inflater.inflate(R.layout.fragment_side_dish, container, false)
        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val sideDish1 = view.findViewById<CheckBox>(R.id.sideDish1)
        val sideDish2 = view.findViewById<CheckBox>(R.id.sideDish2)
        val sideDish3 = view.findViewById<CheckBox>(R.id.sideDish3)
        val sideDish4 = view.findViewById<CheckBox>(R.id.sideDish4)
        val sideDish5 = view.findViewById<CheckBox>(R.id.sideDish5)
        val sideDish6 = view.findViewById<CheckBox>(R.id.sideDish6)

        val sideDishes = mapOf(
            sideDish1 to resources.getString(R.string.salad1),
            sideDish2 to resources.getString(R.string.salad2),
            sideDish3 to resources.getString(R.string.salad3),
            sideDish4 to resources.getString(R.string.soup1),
            sideDish5 to resources.getString(R.string.soup2),
            sideDish6 to resources.getString(R.string.soup3)
        )

        orderViewModel.selectedFoods.observe(viewLifecycleOwner) { selectedFoods ->
            sideDishes.forEach { (checkBox, foodName) ->
                checkBox.isChecked = selectedFoods.contains(foodName)
            }
        }

        sideDishes.forEach { (checkBox, foodName) ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) orderViewModel.addFood(foodName)
                else orderViewModel.removeFood(foodName)
            }
        }

        view.findViewById<Button>(R.id.nextBtn).setOnClickListener {
            findNavController().navigate(R.id.sideDish_to_dessertFragment)
        }
        view.findViewById<Button>(R.id.previousBtn).setOnClickListener {
            findNavController().navigate(R.id.sideDish_to_mainDishFragment)
        }

        return view
    }
}
