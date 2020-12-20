package com.example.jetpackcomposestudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.ExperimentalLazyDsl
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class RecyclerViewActivity : AppCompatActivity() {
    @ExperimentalLazyDsl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                easyList()
            }
        }
    }

    @ExperimentalLazyDsl
    @Composable
    fun easyList() {
        val itemsList = (0..50).toList()
        val itemsIndexedList = listOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z"
        )
        LazyColumn {
            items(itemsList) {
                Text(
                    "Item is $it",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp).fillMaxWidth()
                )
            }

            item {
                Text(
                    "Single item",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp).fillMaxWidth()
                )
            }

            itemsIndexed(itemsIndexedList) { index, item ->
                Text(
                    "Item at index $index is $item",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp).fillMaxWidth()
                )
            }
        }
    }

}