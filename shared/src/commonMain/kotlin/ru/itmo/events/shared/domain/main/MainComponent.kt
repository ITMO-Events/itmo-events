package ru.itmo.events.shared.domain.main

import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.domain.FilterUiEntity
import ru.itmo.events.shared.domain.LoadStates

interface MainComponent {


    val model: Value<Model>

    fun addEvent()

    fun onRetry()

    fun setFilter(id: Int, filters: List<FilterUiEntity>)

    fun toSettings()

    data class Model(
        var events: List<EventCardUiEntity>,
        var filtersList: List<FilterUiEntity>,
        var loadState: LoadStates,
        var errorDescription: String?,
        var onlyVerifiedEvents: Boolean = false,
        val itmoEvents: String = "itmo.events"
    )
}
