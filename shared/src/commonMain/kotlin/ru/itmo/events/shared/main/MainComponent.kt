package ru.itmo.events.shared.main

import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.FilterUiEntity
import ru.itmo.events.shared.LoadStates

interface MainComponent {


    val model: Value<Model>

    fun addEvent()

    fun showFilter()

    fun onRetry()

    data class Model(
        var events: List<EventCardUiEntity>,
        var filtersList: List<FilterUiEntity>,
        var loadState: LoadStates,
        var errorDescription: String?,
        var onlyVerifiedEvents: Boolean = false,
        val itmoEvents: String = "itmo.events"
    )
}
