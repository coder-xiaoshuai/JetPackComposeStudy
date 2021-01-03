package com.example.jetpackcomposestudy.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private var currentEditPosition by mutableStateOf(-1)

    var todoItems by mutableStateOf(listOf<String>())
        private set

    val currentEditItem: String?
        get() = todoItems.getOrNull(currentEditPosition)

    fun addItem(item: String) {
        todoItems = todoItems + listOf(item)
    }

    fun removeItem() {
        todoItems = todoItems.toMutableList().also {
            if (it.size > 0) {
                it.removeAt(it.size - 1)
            }
        }
    }

}