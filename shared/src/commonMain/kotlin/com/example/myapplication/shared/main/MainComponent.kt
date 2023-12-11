package com.example.myapplication.shared.main

import com.arkivanov.decompose.value.Value

interface MainComponent {


    val model: Value<Model>

    fun addEvent()

    fun showFilter()


    data class Model(
        val itmoEvents: String = "itmo.events"
    )
}
