package com.light.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class DessertFragment : Fragment() {
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dessert, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val dessert1 = view.findViewById<CheckBox>(R.id.dessert1)
        val dessert2 = view.findViewById<CheckBox>(R.id.dessert2)
        val dessert3 = view.findViewById<CheckBox>(R.id.dessert3)
        val dessert4 = view.findViewById<CheckBox>(R.id.dessert4)
        val dessert5 = view.findViewById<CheckBox>(R.id.dessert5)
        val dessert6 = view.findViewById<CheckBox>(R.id.dessert6)

        val checkBoxMap = mapOf(
            dessert1 to resources.getString(R.string.cake1),
            dessert2 to resources.getString(R.string.cake2),
            dessert3 to resources.getString(R.string.cake3),
            dessert4 to resources.getString(R.string.pie1),
            dessert5 to resources.getString(R.string.pie2),
            dessert6 to resources.getString(R.string.pie3),
        )

        // Observe selected foods and update checkboxes
        orderViewModel.selectedFoods.observe(viewLifecycleOwner, Observer { selectedFoods ->
            checkBoxMap.forEach { (checkBox, food) ->
                checkBox.isChecked = selectedFoods.contains(food)
            }
        })

        // Set change listeners for checkboxes
        checkBoxMap.forEach { (checkBox, food) ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    orderViewModel.addFood(food)
                } else {
                    orderViewModel.removeFood(food)
                }
            }
        }

        view.findViewById<Button>(R.id.nextBtn).setOnClickListener {
            findNavController().navigate(R.id.dessert_to_drinkFragment)
        }

        view.findViewById<Button>(R.id.previousBtn).setOnClickListener {
            findNavController().navigate(R.id.dessert_to_sideDishFragment)
        }

        return view
    }
}
