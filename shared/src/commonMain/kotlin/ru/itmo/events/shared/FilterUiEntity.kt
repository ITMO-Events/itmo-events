package ru.itmo.events.shared

data class FilterUiEntity(
    val id: Int,
    val name: String,
    val changed: Boolean = false
)
