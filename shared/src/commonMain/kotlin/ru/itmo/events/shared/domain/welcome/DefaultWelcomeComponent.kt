package ru.itmo.events.shared.domain.welcome

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.domain.welcome.WelcomeComponent.Model

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