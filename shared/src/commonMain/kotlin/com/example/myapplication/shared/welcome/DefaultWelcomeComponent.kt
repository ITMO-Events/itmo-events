package com.example.myapplication.shared.welcome

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.update
import com.example.myapplication.shared.getPlatformName
import com.example.myapplication.shared.welcome.WelcomeComponent.Model

class DefaultWelcomeComponent(
    private val componentContext: ComponentContext,
    private val onButtonClick: () -> Unit,
) : WelcomeComponent, ComponentContext by componentContext {

    // Consider preserving and managing the state via a store
    private val state = MutableValue(Model())
    override val model: Value<Model> = state
    override fun onButtonClick() {
        onButtonClick.invoke()
    }
}
