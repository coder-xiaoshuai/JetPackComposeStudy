package com.example.jetpackcomposestudy.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.platform.setContent
import com.example.jetpackcomposestudy.bean.User

class LifeCycleDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LifecycleDemo()
            LifecycleDemo2()

            val user = User()
            user.userId = 0
            user.userName = "张三"
        }
    }

    @Composable
    fun LifecycleDemo() {
        val count = remember { mutableStateOf(0) }

        Column {
            Button(onClick = {
                count.value++
            }) {
                Text("Click me")
            }

            if (count.value < 3) {
                onActive { Log.d("Compose", "onactive with value: " + count.value) }
                onDispose { Log.d("Compose", "onDispose because value=" + count.value) }
                Text("You have clicked the button: " + count.value.toString())
            }
        }
    }

    @Composable
    fun LifecycleDemo2() {

        Column {
            onActive { Log.d("Compose", "onActive") }
            onDispose { Log.d("Compose", "onDispose") }
        }
    }
}