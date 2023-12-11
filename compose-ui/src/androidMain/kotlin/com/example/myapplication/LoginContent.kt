package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.shared.login.LoginComponent


@Composable
fun LoginContent(
    component: LoginComponent
) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(it)) {
            Text("TODO")
            Button(onClick = component::toMain) {
                Text("next")
            }
        }
    }
}