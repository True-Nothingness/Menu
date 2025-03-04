package com.light.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _selectedFoods = MutableLiveData<List<String>>(emptyList()) // Use List<String> instead of MutableList
    val selectedFoods: LiveData<List<String>> = _selectedFoods

    fun addFood(food: String) {
        _selectedFoods.value = _selectedFoods.value?.toMutableList()?.apply {
            if (!contains(food)) add(food)
        }
    }

    fun removeFood(food: String) {
        _selectedFoods.value = _selectedFoods.value?.toMutableList()?.apply { remove(food) }
    }
}
