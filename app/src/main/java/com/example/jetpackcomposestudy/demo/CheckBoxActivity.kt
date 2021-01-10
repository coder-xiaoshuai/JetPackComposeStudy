package com.example.jetpackcomposestudy.demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

class CheckBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            checkBox()
        }
    }

    @Composable
    fun checkBox() {
        var checkCurrent by remember { mutableStateOf(false) }
        val context = ContextAmbient.current
        Row(modifier = Modifier.padding(10.dp)) {
            Text(text = "这是一个CheckBox", modifier = Modifier.align(Alignment.CenterVertically))
            Checkbox(checked = checkCurrent, onCheckedChange = {
                checkCurrent = it
                Toast.makeText(
                    context,
                    "是否选中:$it",
                    Toast.LENGTH_SHORT
                ).show()
                Log.i("zhangshuai", "$it")
            }, modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}