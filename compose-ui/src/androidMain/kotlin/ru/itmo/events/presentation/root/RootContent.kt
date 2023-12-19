package ru.itmo.events.presentation.root

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import ru.itmo.events.presentation.LoginContent
import ru.itmo.events.presentation.welcome.WelcomeContent
import ru.itmo.events.presentation.main.MainContent
import ru.itmo.events.shared.domain.root.RootComponent
import ru.itmo.events.shared.domain.root.RootComponent.Child

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    Surface(modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.systemBars)) {
        Children(
            stack = component.stack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade() + scale())
        ) {
            when (val instance = it.instance) {
                is Child.Main -> MainContent(component = instance.component)
                is Child.Welcome -> WelcomeContent(component = instance.component)
                is Child.Login -> LoginContent(component = instance.component)
                is Child.AddEvent -> TODO()
                is Child.Settings -> TODO()
                is Child.AboutEvent -> TODO()
            }
        }
    }
}
