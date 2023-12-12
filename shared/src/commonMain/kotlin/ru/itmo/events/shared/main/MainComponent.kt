package ru.itmo.events.shared.main

import com.arkivanov.decompose.value.Value

interface MainComponent {


    val model: Value<Model>

    fun addEvent()

    fun showFilter()


    data class Model(
        var items: List<EventCardUiEntity>,
        val itmoEvents: String = "itmo.events"
    )
}
