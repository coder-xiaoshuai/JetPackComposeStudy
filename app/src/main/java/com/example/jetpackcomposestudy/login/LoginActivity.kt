package com.example.jetpackcomposestudy.login

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                loginUI()
            }
        }
    }

    @Composable
    fun loginUI() {
        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
            var phone by savedInstanceState { "" }
            var password by savedInstanceState { "" }
            TextField(
                value = phone ?: "",
                onValueChange = {
                    phone = it
                },
                label = { Text(text = "账号") },
                placeholder = {
                    Text(text = "请输入手机号")
                },
                keyboardType = KeyboardType.Phone,
                modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
                backgroundColor = Color.White
            )

            TextField(
                value = password,
                onValueChange = {
                    password = it
                }, label = { Text(text = "密码") },
                placeholder = {
                    Text(text = "请输入密码")
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardType = KeyboardType.Password,
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.White
            )

            Button(
                content = { Text(text = "登录", textAlign = TextAlign.Center) },
                onClick = {
                    if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
                        Toast.makeText(
                            this@LoginActivity,
                            "账号或密码不能为空",
                            Toast.LENGTH_SHORT
                        ).show()
                        return@Button
                    }
                    Toast.makeText(
                        this@LoginActivity,
                        "账号:${phone},密码:${password}",
                        Toast.LENGTH_SHORT
                    ).show()
                },
                backgroundColor = Color.Yellow,
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            )
        }
    }
}