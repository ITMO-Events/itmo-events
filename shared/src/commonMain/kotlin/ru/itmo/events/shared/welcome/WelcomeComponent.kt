package ru.itmo.events.shared.welcome

import com.arkivanov.decompose.value.Value

interface WelcomeComponent {

    val model: Value<Model>

    fun onButtonClick()

    data class Model(
        val greetingText: String = "Добро пожаловать в ITMO.Events",
        val loginWith: String = "Войти с помощью"
    )
}
