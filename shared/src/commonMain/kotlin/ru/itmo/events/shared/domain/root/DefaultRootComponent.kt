package ru.itmo.events.shared.domain.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.popTo
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import ru.itmo.events.shared.domain.login.DefaultLoginComponent
import ru.itmo.events.shared.domain.login.LoginComponent
import ru.itmo.events.shared.domain.main.DefaultMainComponent
import ru.itmo.events.shared.domain.main.MainComponent
import ru.itmo.events.shared.domain.root.RootComponent.Child
import ru.itmo.events.shared.domain.welcome.DefaultWelcomeComponent
import ru.itmo.events.shared.domain.welcome.WelcomeComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>> = childStack(
        source = navigation,
        initialConfiguration = Config.Welcome,
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(config: Config, childComponentContext: ComponentContext): Child =
        when (config) {
            is Config.Main -> Child.Main(mainComponent(childComponentContext))
            is Config.Welcome -> Child.Welcome(welcomeComponent(childComponentContext))
            is Config.Login -> Child.Login(loginComponent(childComponentContext))
            is Config.Settings -> Child.Settings()
            is Config.AddEvent -> Child.AddEvent()
        }

    private fun mainComponent(componentContext: ComponentContext): MainComponent =
        DefaultMainComponent(
            componentContext = componentContext,
            onSettingsClick = { navigation.push(Config.Settings) },
            onAddEventClick = { navigation.push(Config.AddEvent) }
        )

    private fun welcomeComponent(componentContext: ComponentContext): WelcomeComponent =
        DefaultWelcomeComponent(
            componentContext = componentContext,
            onButtonClick = { navigation.push(Config.Login) },
        )

    private fun loginComponent(componentContext: ComponentContext): LoginComponent =
        DefaultLoginComponent(componentContext) {
            navigation.push(Config.Main)
        }

    override fun onBackClicked(toIndex: Int) {
        navigation.popTo(index = toIndex)
    }

    private sealed interface Config : Parcelable {
        @Parcelize
        data object Main : Config

        @Parcelize
        data object Welcome : Config

        @Parcelize
        data object Login : Config

        @Parcelize
        data object Settings : Config

        @Parcelize
        data object AddEvent : Config
    }
}
