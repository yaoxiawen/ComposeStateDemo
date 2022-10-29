package com.example.composestatedemo.todo.one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.composestatedemo.todo.TodoItem
import com.example.composestatedemo.ui.theme.ComposeStateDemoTheme

class TodoActivity : ComponentActivity() {
    private val viewModel by viewModels<TodoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateDemoTheme {
                TodoActivityScreen()
            }
        }
    }

    @Composable
    fun TodoActivityScreen() {
        //LiveData.observeAsState 状态监听，适用于viewmodel的MutableLiveData
//        val items: List<TodoItem> by viewModel.todoItems.observeAsState(listOf())
        TodoScreen(
            items = viewModel.todoItems,
            currentlyEditing = viewModel.currentEditItem,
            onAddItem = viewModel::addItem,
            onRemoveItem = viewModel::removeItem,
            onStartEdit = viewModel::onEditItemSelected,
            onEditItemChange = viewModel::onEditItemChange,
            onEditDone = viewModel::onEditDone
        )
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        ComposeStateDemoTheme {
            TodoActivityScreen()
        }
    }
}

