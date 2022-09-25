package com.example.composestatedemo.todo.one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composestatedemo.todo.TodoIcon
import com.example.composestatedemo.todo.TodoItem
import com.example.composestatedemo.ui.theme.ComposeStateDemoTheme

class TodoActivity : ComponentActivity() {
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
        val items = listOf(
            TodoItem("Learn compose", TodoIcon.Event),
            TodoItem("Take the codelab"),
            TodoItem("Apply state", TodoIcon.Done),
            TodoItem("Build dynamic UIs", TodoIcon.Square)
        )
        TodoScreen(items)
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        ComposeStateDemoTheme {
            TodoActivityScreen()
        }
    }
}

