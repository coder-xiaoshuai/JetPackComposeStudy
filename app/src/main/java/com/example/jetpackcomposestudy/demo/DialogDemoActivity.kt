package com.example.jetpackcomposestudy.demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import com.example.jetpackcomposestudy.ui.typography

class DialogDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var openDialog = remember { mutableStateOf(false) }
            Button(onClick = {
                openDialog.value = true
            }) {
                Text(text = "弹出dialog")
            }
            ShowAlertDialog(openDialog)
        }
    }

    @Composable
    fun showDialog() {
        val context = ContextAmbient.current
        Button(onClick = {
            //@Composable invocations can only happen from the context of a @Composable function
//            AlertDialog(onDismissRequest = {
//                Toast.makeText(
//                    context,
//                    "dialog关闭了",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }, title = { Text(text = "这是标题") }, text = { Text(text = "这是内容") }, buttons = {})
//            AlertDialog(onDismissRequest = { /*TODO*/ },title = {},text = {},buttons = {})
        }) {
            Text(text = "显示dialog")
        }
    }

    @Composable
    private fun ShowAlertDialog(showDialog:MutableState<Boolean>) {
        val text = remember { mutableStateOf("哈哈哈哈哈哈") }
        if (showDialog.value) {
            AlertDialog(
                title = { Text("Title") },
                text = {
                    OutlinedTextField(
                        value = text.value,
                        onValueChange = {
                            text.value = it
                        },
                        label = {
                            ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
                                Text(
                                    text = "输入内容",
                                    style = typography.body2
                                )
                            }
                        }
                    )
                },
                onDismissRequest = {
                    Log.i("zhangshuai", "onDismissRequest")
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                            Toast.makeText(this@DialogDemoActivity, "点击了确定", Toast.LENGTH_SHORT)
                                .show()
                            Log.i("zhangshuai", "点击了确定")
                        },
                    ) {
                        Text("Confirm")
                    }
                }
            )
        } else {
            Text("Confirmed")
        }
    }

}