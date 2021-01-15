package com.example.jetpackcomposestudy.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposestudy.bean.User

class LifeCycleDemoActivity : AppCompatActivity() {
    private val ActiveUser = ambientOf<User> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val user = User()
            user.userId = 0
            user.userName = "张三"
            Providers(ActiveUser provides user) {
                LifecycleDemo1()
            }
            LifecycleDemo()
//            LifecycleDemo2()

            val user2 = User()
            user2.userId = 1
            user2.userName = "李四"
            Providers(ActiveUser provides user2) {
                LifecycleDemo2()
            }


        }
    }

    @Composable
    fun LifecycleDemo() {
        val count = remember { mutableStateOf(0) }

        Column(modifier = Modifier.fillMaxHeight()) {
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
    fun LifecycleDemo1() {
        val userName = ActiveUser.current?.userName
        Column {
            onActive { Log.d("Compose", "onActive${userName}") }
            onDispose { Log.d("Compose", "onDispose${userName}") }
        }
    }

    @Composable
    fun LifecycleDemo2() {
        val userName = ActiveUser.current?.userName
        Column {
            onActive { Log.d("Compose", "onActive2${userName}") }
            onDispose { Log.d("Compose", "onDispose2${userName}") }
        }
    }

    @Composable
    fun UserTest() {
//       val user = ActiveUser.current
    }
}