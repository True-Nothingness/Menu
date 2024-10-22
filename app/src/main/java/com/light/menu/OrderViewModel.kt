package com.light.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _selectedFoods = MutableLiveData<MutableList<String>>(mutableListOf())
    val selectedFoods: LiveData<MutableList<String>> = _selectedFoods

    fun addFood(food: String) {
        _selectedFoods.value?.let {
            if (!it.contains(food)) {
                it.add(food)
                _selectedFoods.value = it
            }
        }
    }

    fun removeFood(food: String) {
        _selectedFoods.value?.let {
            it.remove(food)
            _selectedFoods.value = it
        }
    }
}
