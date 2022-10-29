package com.example.composestatedemo.todo.one

import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composestatedemo.todo.TodoItem


class TodoViewModel : ViewModel() {
    //TodoItem集合只读，ViewModel成为状态容器，因此不需要remember
    var todoItems = mutableStateListOf<TodoItem>()
        private set

    //当前正在编辑的TodoItem的索引位置
    private var currentEditPosition by mutableStateOf(-1)

    //当前正在编辑的TodoItem的对象
    val currentEditItem: TodoItem?
        get() = todoItems.getOrNull(currentEditPosition)

    fun addItem(item: TodoItem) {
        todoItems.add(item)
    }

    fun removeItem(item: TodoItem) {
        todoItems.remove(item)
        onEditDone()
    }

    fun onEditDone() {
        currentEditPosition = -1
    }

    fun onEditItemSelected(item: TodoItem) {
        currentEditPosition = todoItems.indexOf(item)
    }

    fun onEditItemChange(item: TodoItem) {
        todoItems[currentEditPosition] = item
    }
}