package ru.itmo.events.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.itmo.events.compose.R
import ru.itmo.events.shared.domain.LoadStates
import ru.itmo.events.presentation.theme.AppTheme

@Composable
fun StatesContent(
    loadState: LoadStates,
    emptyDescription: String? = null,
    errorDescription: String? = null,
    onRetry: () -> Unit
) {
    if (loadState != LoadStates.LOADED)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when (loadState) {
                LoadStates.EMPTY -> {
                    StatesContentBody(painterResource(R.drawable.ic_empty), emptyDescription ?: "")
                }

                LoadStates.ERROR -> {
                    StatesContentBody(
                        painterResource(R.drawable.ic_error),
                        errorDescription ?: "",
                        onRetry
                    )
                }

                LoadStates.LOADING -> {
                    CircularProgressIndicator(modifier = Modifier.size(120.dp))
                }

                else -> {}
            }
        }
}

@Composable
fun StatesContentBody(icon: Painter, text: String, onRetry: (() -> Unit)? = null) {
    Icon(
        icon,
        contentDescription = null,
        tint = Color.Unspecified,
        modifier = Modifier.size(120.dp)
    )
    Spacer(modifier = Modifier.size(8.dp))
    Text(
        text,
        style = MaterialTheme.typography.bodyMedium
    )
    if (onRetry != null) {
        Spacer(modifier = Modifier.size(8.dp))
        Button(onRetry) {
            Text("Повторить попытку", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun PreviewStatesContentBody() {
    AppTheme{
        StatesContent(loadState = LoadStates.LOADING) {
            
        }
    }
}