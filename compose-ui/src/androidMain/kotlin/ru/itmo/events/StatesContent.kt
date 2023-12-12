package ru.itmo.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.itmo.events.compose.R

@Composable
fun StatesContent(
    isError: Boolean = false,
    isEmpty: Boolean = false,
    emptyDescription: String? = null,
    errorDescription: String? = null,
    onRetry: () -> Unit
) {
    if (isError || isEmpty)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (isError) {
                Icon(
                    painterResource(R.drawable.ic_error),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    errorDescription ?: "",
                    style = MaterialTheme.typography.bodyMedium
                ) /* TODO Добавить заглушку вместо null  */
                Spacer(modifier = Modifier.size(8.dp))
                Button(onRetry) {
                    Text("Повторить попытку", style = MaterialTheme.typography.bodyMedium)
                }
            } else if (isEmpty) {
                Icon(
                    painterResource(R.drawable.ic_empty),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    emptyDescription ?: "",
                    style = MaterialTheme.typography.bodyMedium
                ) /* TODO убрать текст куда то  */
            }
        }
}