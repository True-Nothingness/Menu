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
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_main_dish, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val mainDish1 = view.findViewById<CheckBox>(R.id.mainDish1)
        mainDish1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pizza1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pizza1))
            }
        }
        val mainDish2 = view.findViewById<CheckBox>(R.id.mainDish2)
        mainDish2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pizza2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pizza2))
            }
        }
        val mainDish3 = view.findViewById<CheckBox>(R.id.mainDish3)
        mainDish3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pizza3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pizza3))
            }
        }
        val mainDish4 = view.findViewById<CheckBox>(R.id.mainDish4)
        mainDish4.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pasta1))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pasta1))
            }
        }
        val mainDish5 = view.findViewById<CheckBox>(R.id.mainDish5)
        mainDish5.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pasta2))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pasta2))
            }
        }
        val mainDish6 = view.findViewById<CheckBox>(R.id.mainDish6)
        mainDish6.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                orderViewModel.addFood(resources.getString(R.string.pasta3))
            } else {
                orderViewModel.removeFood(resources.getString(R.string.pasta3))
            }
        }
        val nextButton = view.findViewById<Button>(R.id.nextBtn)
        nextButton.setOnClickListener {
            findNavController().navigate(R.id.mainDish_to_sideDish)
        }

        return view
    }
}