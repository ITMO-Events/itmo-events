package ru.itmo.events.shared.main

import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.LoadStates

interface MainComponent {


    val model: Value<Model>

    fun addEvent()

    fun showFilter()

    fun onRetry()

    data class Model(
        var items: List<EventCardUiEntity>,
        var loadState: LoadStates,
        var errorDescription: String?,
        val itmoEvents: String = "itmo.events"
    )
}
