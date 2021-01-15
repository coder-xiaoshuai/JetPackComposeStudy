package com.example.jetpackcomposestudy.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class AnimationDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { CrossfadeDemo() }
    }


    enum class MyColors(val color: Color) {
        Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
    }

    @Composable
    fun CrossfadeDemo() {
        var currentColor by remember { mutableStateOf(MyColors.Red) }
        Column {
            Row {
                MyColors.values().forEach { myColors ->
                    Button(
                        onClick = { currentColor = myColors },
                        Modifier.weight(1f, true)
                            .preferredHeight(48.dp),
                        backgroundColor = myColors.color
                    ) {
                        Text(myColors.name)
                    }
                }
            }
            Crossfade(current = currentColor, animation = tween(3000)) { selectedColor ->
                Box(modifier = Modifier.fillMaxSize().background(selectedColor.color))
            }
        }
    }
}
