package com.example.jetpackcomposestudy.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.style.TextAlign
import androidx.ui.tooling.preview.Preview

class SizeDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                weightTest1()
                weightTest2()
            }

        }
    }

    @Composable
    private fun weightTest1() {
        Row(modifier = Modifier.fillMaxWidth().background(Color.Magenta)) {
            Text(
                text = "文本1",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(0.25f).background(Color.Red)
            )
            Text(
                text = "文本2",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(1/3f).background(Color.Yellow)
            )
            Text(
                text = "文本3",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(0.5f).background(Color.Blue)
            )
            Text(
                text = "文本4",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().background(Color.Cyan)
            )
        }
    }

    @Composable
    private fun weightTest2() {
        Row(modifier = Modifier.fillMaxWidth().background(Color.Magenta)) {
            Text(
                text = "文本1",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).background(Color.Red)
            )
            Text(
                text = "文本2",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).background(Color.Yellow)
            )
            Text(
                text = "文本3",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).background(Color.Blue)
            )
            Text(
                text = "文本4",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f).background(Color.Cyan)
            )
        }
    }

    @Preview(name = "预览")
    @Composable
    private fun previewTest() {
        Column {
            weightTest1()
            weightTest2()
        }
    }
}