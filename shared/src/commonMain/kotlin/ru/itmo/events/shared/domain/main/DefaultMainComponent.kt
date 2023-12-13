package ru.itmo.events.shared.domain.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.domain.LoadStates

class DefaultMainComponent(
    private val componentContext: ComponentContext,
) : MainComponent, ComponentContext by componentContext {

    private val state =
        MutableValue(MainComponent.Model(listOf(), listOf(), LoadStates.EMPTY, null))
    override val model: Value<MainComponent.Model> = state

    override fun addEvent() {

    }

    override fun showFilter() {
        TODO("Not yet implemented")
    }

    override fun onRetry() {
        TODO("Not yet implemented")
    }


}
