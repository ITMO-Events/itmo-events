package ru.itmo.events.shared.login

import com.arkivanov.decompose.ComponentContext

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