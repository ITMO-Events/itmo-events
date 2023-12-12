package ru.itmo.events.shared.main


data class EventCardUiEntity(
    val id: Int,
    val name: String,
//    val preview: Painter, /* Возможно надо поставить другой тип */
    val date: String,
    val description: String,
)
