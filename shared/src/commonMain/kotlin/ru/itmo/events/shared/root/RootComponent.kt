package ru.itmo.events.shared.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import ru.itmo.events.shared.login.LoginComponent
import ru.itmo.events.shared.main.MainComponent
import ru.itmo.events.shared.welcome.WelcomeComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked(toIndex: Int)

    sealed class Child {
        class Welcome(val component: WelcomeComponent) : Child()
        class Main(val component: MainComponent) : Child()
        class Login(val component: LoginComponent) : Child()
    }
}
