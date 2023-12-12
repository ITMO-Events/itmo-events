package ru.itmo.events.shared.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DefaultMainComponent(
    private val componentContext: ComponentContext,
    private val onShowWelcome: () -> Unit,
) : MainComponent, ComponentContext by componentContext {

    private val state = MutableValue(MainComponent.Model())
    override val model: Value<MainComponent.Model> = state

    override fun addEvent() {

    }

    override fun showFilter() {
        TODO("Not yet implemented")
    }


}
