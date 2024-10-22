package com.light.menu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CheckoutFragment : Fragment() {
    private lateinit var orderViewModel: OrderViewModel
    private lateinit var orderAdapter: OrderAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val orderList: RecyclerView = view.findViewById(R.id.orderList)
        orderList.layoutManager = LinearLayoutManager(requireContext())
        val orderAdapter = OrderAdapter(requireContext())
        orderList.adapter = orderAdapter

        orderViewModel.selectedFoods.observe(requireActivity(), Observer { foodList ->
            // Update the adapter with new data
            foodList?.let {
                orderAdapter.setFoods(it)
            }
        })
        val nextButton = view.findViewById<Button>(R.id.nextBtn)
        val prevButton = view.findViewById<Button>(R.id.previousBtn)

        nextButton.setOnClickListener{
            activity?.finish()
        }
        prevButton.setOnClickListener{
            findNavController().navigate(R.id.checkout_to_drinkFragment)
        }
        return view
    }
}