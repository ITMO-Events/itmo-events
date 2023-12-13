package ru.itmo.events.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.itmo.events.presentation.theme.AppTheme
import ru.itmo.events.shared.domain.FilterUiEntity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersContent(
    verified: Boolean,
    filtersList: List<FilterUiEntity>,
    onVerifyClick: () -> Unit,
    onClick: (id: Int) -> Unit
) {
    var onlyVerified by remember { mutableStateOf(verified) }

    LazyRow(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
    ) {
        item {
            FilterChip(
                selected = onlyVerified,
                onClick = {
                    onVerifyClick.invoke()
                    onlyVerified = !onlyVerified
                },
                label = { Text(text = "Проверено") },
                leadingIcon = {
                    Icon(Icons.Default.Check, contentDescription = null)
                },
                modifier = Modifier.padding(end = 8.dp)
            )
        }
        items(filtersList) {
            InputChip(
                selected = it.changed,
                onClick = { onClick(it.id) },
                label = { Text(text = it.name) },
                modifier = Modifier.padding(end = 8.dp),
                trailingIcon = {})
        }
    }
}

@Preview
@Composable
fun FiltersContentPreview() {
    AppTheme {
        FiltersContent(true, listOf(FilterUiEntity(0, "", false)), {}, {})
    }
}