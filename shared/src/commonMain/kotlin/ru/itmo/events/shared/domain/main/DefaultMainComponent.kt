package ru.itmo.events.shared.domain.main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.domain.FilterUiEntity
import ru.itmo.events.shared.domain.LoadStates

class DefaultMainComponent(
    private val componentContext: ComponentContext,
    private val onSettingsClick: () -> Unit,
    private val onAddEventClick: () -> Unit
) : MainComponent, ComponentContext by componentContext {

    private val state =
        MutableValue(MainComponent.Model(listOf(), listOf(), LoadStates.EMPTY, null))
    override val model: Value<MainComponent.Model> = state

    override fun addEvent() {
        onSettingsClick.invoke()
    }

    override fun onRetry() {
        TODO("Not yet implemented")
    }

    override fun setFilter(id: Int, filters: List<FilterUiEntity>) {
        TODO("Not yet implemented")
    }

    override fun toSettings() {
        onAddEventClick.invoke()
    }
}
