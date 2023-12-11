package com.example.myapplication.shared.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.example.myapplication.shared.welcome.WelcomeComponent

class DefaultLoginComponent(
    private val componentContext: ComponentContext,
    private val onLoginClick: () -> Unit
) : LoginComponent,
    ComponentContext by componentContext {

    //    val model: Value<Model>
    override fun toMain() {
        onLoginClick.invoke()
    }


}