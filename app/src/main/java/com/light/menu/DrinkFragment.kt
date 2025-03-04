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
    ): View {
        val view = inflater.inflate(R.layout.fragment_drink, container, false)
        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val drink1 = view.findViewById<CheckBox>(R.id.drink1)
        val drink2 = view.findViewById<CheckBox>(R.id.drink2)
        val drink3 = view.findViewById<CheckBox>(R.id.drink3)
        val drink4 = view.findViewById<CheckBox>(R.id.drink4)
        val drink5 = view.findViewById<CheckBox>(R.id.drink5)
        val drink6 = view.findViewById<CheckBox>(R.id.drink6)

        val drinks = mapOf(
            drink1 to resources.getString(R.string.coffee1),
            drink2 to resources.getString(R.string.coffee2),
            drink3 to resources.getString(R.string.coffee3),
            drink4 to resources.getString(R.string.soda1),
            drink5 to resources.getString(R.string.soda2),
            drink6 to resources.getString(R.string.soda3)
        )

        orderViewModel.selectedFoods.observe(viewLifecycleOwner) { selectedFoods ->
            drinks.forEach { (checkBox, foodName) ->
                checkBox.isChecked = selectedFoods.contains(foodName)
            }
        }

        drinks.forEach { (checkBox, foodName) ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) orderViewModel.addFood(foodName)
                else orderViewModel.removeFood(foodName)
            }
        }

        view.findViewById<Button>(R.id.nextBtn).setOnClickListener {
            findNavController().navigate(R.id.drink_to_checkoutFragment)
        }
        view.findViewById<Button>(R.id.previousBtn).setOnClickListener {
            findNavController().navigate(R.id.drink_to_dessertFragment)
        }

        return view
    }
}
