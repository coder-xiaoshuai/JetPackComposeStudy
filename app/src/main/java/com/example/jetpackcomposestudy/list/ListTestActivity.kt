package com.example.jetpackcomposestudy.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import com.example.jetpackcomposestudy.R

class ListTestActivity : AppCompatActivity() {
    @ExperimentalLazyDsl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                InitView()
            }
        }
    }

    @ExperimentalLazyDsl
    @Composable
    fun InitView() {
        val listViewModel = viewModel(modelClass = ListViewModel::class.java)
        Scaffold(topBar = {
            Text(
                "动态列表测试",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = colorResource(
                            id = R.color.color_card1
                        )
                    ).fillMaxWidth().padding(16.dp)
            )
        }, bottomBar = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    listViewModel.addItem("新增的ITEM")
                }) {
                    Text(text = "增加一个Item")
                }
                Button(onClick = {
                    listViewModel.removeItem()
                }) {
                    Text(text = "删除一个Item")
                }
            }
        }) {
            MyList(listViewModel = listViewModel)
        }
    }

    @ExperimentalLazyDsl
    @Composable
    fun MyList(listViewModel: ListViewModel) {
        LazyColumn(modifier = Modifier.padding(bottom = 50.dp)) {
            items(listViewModel.todoItems) {
                Text(
                    "Item is $it",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}