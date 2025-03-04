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

class MainDishFragment : Fragment() {
    private lateinit var orderViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main_dish, container, false)
        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val mainDish1 = view.findViewById<CheckBox>(R.id.mainDish1)
        val mainDish2 = view.findViewById<CheckBox>(R.id.mainDish2)
        val mainDish3 = view.findViewById<CheckBox>(R.id.mainDish3)
        val mainDish4 = view.findViewById<CheckBox>(R.id.mainDish4)
        val mainDish5 = view.findViewById<CheckBox>(R.id.mainDish5)
        val mainDish6 = view.findViewById<CheckBox>(R.id.mainDish6)

        val mainDishes = mapOf(
            mainDish1 to resources.getString(R.string.pizza1),
            mainDish2 to resources.getString(R.string.pizza2),
            mainDish3 to resources.getString(R.string.pizza3),
            mainDish4 to resources.getString(R.string.pasta1),
            mainDish5 to resources.getString(R.string.pasta2),
            mainDish6 to resources.getString(R.string.pasta3)
        )

        orderViewModel.selectedFoods.observe(viewLifecycleOwner) { selectedFoods ->
            mainDishes.forEach { (checkBox, foodName) ->
                checkBox.isChecked = selectedFoods.contains(foodName)
            }
        }

        mainDishes.forEach { (checkBox, foodName) ->
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) orderViewModel.addFood(foodName)
                else orderViewModel.removeFood(foodName)
            }
        }

        view.findViewById<Button>(R.id.nextBtn).setOnClickListener {
            findNavController().navigate(R.id.mainDish_to_sideDish)
        }

        return view
    }
}
