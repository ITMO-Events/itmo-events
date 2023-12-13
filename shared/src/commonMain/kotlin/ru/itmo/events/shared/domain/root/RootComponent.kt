package ru.itmo.events.shared.domain.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.domain.login.LoginComponent
import ru.itmo.events.shared.domain.main.MainComponent
import ru.itmo.events.shared.domain.welcome.WelcomeComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class Welcome(val component: WelcomeComponent) : Child()
        class Main(val component: MainComponent) : Child()
        class Login(val component: LoginComponent) : Child()
    }
}
