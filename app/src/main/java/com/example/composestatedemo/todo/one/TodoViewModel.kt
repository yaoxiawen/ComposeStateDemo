package com.example.composestatedemo.todo.one

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composestatedemo.todo.TodoItem


class TodoViewModel : ViewModel() {
    private var _todoItems = MutableLiveData(listOf<TodoItem>())
    val todoItems: LiveData<List<TodoItem>> = _todoItems

    fun addItem(item: TodoItem) {
        //要保证_todoItems所指向的对象有变，不能还是原来的list对象只是里面内容变了
        //plus 保证了是新创建了一个ArrayList
        _todoItems.value = _todoItems.value?.plus(item)
    }

    fun removeItem(item: TodoItem) {
        //toMutableList保证了是新创建了一个ArrayList
        _todoItems.value = _todoItems.value?.toMutableList().also {
            it?.remove(item)
        }
    }
}