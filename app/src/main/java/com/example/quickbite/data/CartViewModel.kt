package com.example.quickbite.data

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    private val _cartItems = mutableStateListOf<Cartitem>()
    val cartItems: List<Cartitem> get() = _cartItems

    fun addItem(item: Cartitem) {
        val existing = _cartItems.find { it.name == item.name }
        if (existing != null) {
            val updated = existing.copy(quantity = existing.quantity + 1)
            _cartItems[_cartItems.indexOf(existing)] = updated
        } else {
            _cartItems.add(item)
        }
    }

    fun getTotalPrice(): Double {
        // Example: return dummy value; update with real prices if needed
        return _cartItems.sumOf { it.quantity * it.price } // Assume each item is 10.0
    }
    fun increaseQuantity(item: Cartitem) {
        val index = _cartItems.indexOf(item)
        if (index >= 0) {
            _cartItems[index] = item.copy(quantity = item.quantity + 1)
        }
    }

    fun decreaseQuantity(item: Cartitem) {
        val index = _cartItems.indexOf(item)
        if (index >= 0) {
            val newQuantity = item.quantity - 1
            if (newQuantity > 0) {
                _cartItems[index] = item.copy(quantity = newQuantity)
            } else {
                _cartItems.removeAt(index)
            }
        }
    }

    fun clearAll() {
        _cartItems.clear()
    }
}
