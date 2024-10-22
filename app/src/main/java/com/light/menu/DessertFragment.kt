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

class DessertFragment : Fragment() {
    private lateinit var orderViewModel: OrderViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_dessert, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val dessert1 = view.findViewById<CheckBox>(R.id.dessert1)
        dessert1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.cake1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.cake1))
            }
        }
        val dessert2 = view.findViewById<CheckBox>(R.id.dessert2)
        dessert2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.cake2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.cake2))
            }
        }
        val dessert3 = view.findViewById<CheckBox>(R.id.dessert3)
        dessert3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.cake3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.cake3))
            }
        }
        val dessert4 = view.findViewById<CheckBox>(R.id.dessert4)
        dessert4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pie1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pie1))
            }
        }
        val dessert5 = view.findViewById<CheckBox>(R.id.dessert5)
        dessert5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pie2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pie2))
            }
        }
        val dessert6 = view.findViewById<CheckBox>(R.id.dessert6)
        dessert6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pie3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pie3))
            }
        }
        val nextButton = view.findViewById<Button>(R.id.nextBtn)
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.dessert_to_drinkFragment)
        }
        val prevButton = view.findViewById<Button>(R.id.previousBtn)
        prevButton.setOnClickListener {
            findNavController().navigate(R.id.dessert_to_sideDishFragment)
        }
        return view
    }
}