package com.example.composestatedemo.todo.one

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composestatedemo.todo.TodoItem

@Composable
fun TodoItemInput(onItemComplete: (TodoItem) -> Unit) {
    //MutableState 类似于MutableLiveData，在compose中使用，配合remember ，不然会在每次重组时重新初始化
    //通过MutableState三种方式声明一个可组合对象
    //val state = remember{mutableStateOf(default)}
    //var state by remember{mutableStateOf(default)}
    //val (value,setValue) = remember{mutableStateOf(default)}
    val (text, setText) = remember {
        mutableStateOf("")
    }
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            TodoInputText(
                text = text,
                onTextChange = setText,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            )
            TodoEditButton(
                onClick = {
                    onItemComplete(TodoItem(text))
                    setText("")
                },
                text = "Add",
                modifier = Modifier.align(Alignment.CenterVertically),
                enabled = text.isNotBlank()
            )
        }
    }
}

/**
 * 输入框，参数1外部传入显示内容，参数2传往外部内容变化
 */
@Composable
fun TodoInputText(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        modifier = modifier
    )
}

/**
 * 按钮
 */
@Composable
fun TodoEditButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(),
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text)
    }
}