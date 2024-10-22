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


class DrinkFragment : Fragment() {
    private lateinit var orderViewModel: OrderViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_drink, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val drink1 = view.findViewById<CheckBox>(R.id.drink1)
        drink1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.coffee1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.coffee1))
            }
        }
        val drink2 = view.findViewById<CheckBox>(R.id.drink2)
        drink2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.coffee2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.coffee2))
            }
        }
        val drink3 = view.findViewById<CheckBox>(R.id.drink3)
        drink3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.coffee3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.coffee3))
            }
        }
        val drink4 = view.findViewById<CheckBox>(R.id.drink4)
        drink4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.soda1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.soda1))
            }
        }
        val drink5 = view.findViewById<CheckBox>(R.id.drink5)
        drink5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.soda2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.soda2))
            }
        }
        val drink6 = view.findViewById<CheckBox>(R.id.drink6)
        drink6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.soda3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.soda3))
            }
        }
        val nextButton = view.findViewById<Button>(R.id.nextBtn)
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.drink_to_checkoutFragment)
        }
        val prevButton = view.findViewById<Button>(R.id.previousBtn)
        prevButton.setOnClickListener {
            findNavController().navigate(R.id.drink_to_dessertFragment)
        }
        return view
    }
}