package ru.itmo.events.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import ru.itmo.events.root.RootContent
import ru.itmo.events.shared.root.DefaultRootComponent
import ru.itmo.events.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = DefaultRootComponent(componentContext = defaultComponentContext())

        setContent {
            AppTheme {
                RootContent(component = root)
            }
        }
    }
}
