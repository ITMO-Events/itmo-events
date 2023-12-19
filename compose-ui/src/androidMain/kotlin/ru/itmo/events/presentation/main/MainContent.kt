package ru.itmo.events.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import ru.itmo.events.presentation.StatesContent
import ru.itmo.events.compose.R
import ru.itmo.events.presentation.FiltersContent
import ru.itmo.events.shared.domain.main.MainComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainContent(
    component: MainComponent,
    modifier: Modifier = Modifier,
) {
    val model by component.model.subscribeAsState(structuralEqualityPolicy())

    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = model.itmoEvents) },
                actions = {
                    IconButton(onClick = component::toSettings) {
                        Icon(Icons.Outlined.AccountCircle, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = component::addEvent) {
                Icon(Icons.Filled.Add, contentDescription = null) // TODO поменять иконку
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            FiltersContent(
                verified = model.onlyVerifiedEvents,
                filtersList = model.filtersList,
                onVerifyClick = { model.onlyVerifiedEvents = !model.onlyVerifiedEvents },
                onClick = { }
            )
            StatesContent(
                model.loadState,
                errorDescription = model.errorDescription,
                emptyDescription = "Мероприятий нет",
                onRetry = component::onRetry
            )

            if (model.events.isNotEmpty()) {
                LazyColumn {
                    items(model.events) {
                        EventCard(it.name,
                            painterResource(R.drawable.ic_icon_test),
                            it.date,
                            it.description, {}, {})
                    }
                }
            }
        }
    }
}
