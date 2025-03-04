package com.light.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
    ): View {
        val view = inflater.inflate(R.layout.fragment_checkout, container, false)

        orderViewModel = ViewModelProvider(requireActivity())[OrderViewModel::class.java]

        val orderList: RecyclerView = view.findViewById(R.id.orderList)
        orderList.layoutManager = LinearLayoutManager(requireContext())

        orderAdapter = OrderAdapter(requireContext())
        orderList.adapter = orderAdapter

        orderViewModel.selectedFoods.observe(viewLifecycleOwner) { foodList ->
            orderAdapter.setFoods(foodList)
        }

        view.findViewById<Button>(R.id.nextBtn).setOnClickListener {
            activity?.finish()
        }
        view.findViewById<Button>(R.id.previousBtn).setOnClickListener {
            findNavController().navigate(R.id.checkout_to_drinkFragment)
        }

        return view
    }
}
