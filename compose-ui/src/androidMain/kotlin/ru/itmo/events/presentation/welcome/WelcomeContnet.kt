package ru.itmo.events.presentation.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import ru.itmo.events.compose.R
import ru.itmo.events.shared.domain.welcome.WelcomeComponent

@Composable
internal fun WelcomeContent(
    component: WelcomeComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.model.subscribeAsState()

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            model.loginWith,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(end = 4.dp)
                        )
                        Icon(painterResource(R.drawable.ic_itmo_id), contentDescription = null)
                    }
                },
                icon = {},
                onClick = { component.onButtonClick() })
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                model.greetingText,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxHeight(0.5f).padding(start = 16.dp, end = 16.dp),
            )
        }
    }
}
