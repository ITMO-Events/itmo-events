package com.example.myapplication.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.theme.AppTheme

@Composable
fun EventCard(
    name: String,
    date: String,
    description: String,
    onClick: () -> Unit,
    onAddCalendarClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth()
            .clickable { onClick.invoke() }) {
//        Icon(imagePreview, contentDescription = null)
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(name, style = MaterialTheme.typography.bodyLarge)
            Text(
                date,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(description, style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.fillMaxWidth())
        Icon(Icons.Default.Add, contentDescription = null)
    }
}

@Composable
@Preview
fun EventCardPreview() {
    AppTheme {
        EventCard(
            "MegaQuiz X",
//            painterResource(R.drawable.ic_itmo_id),
            "22.09.2005",
            "Supporting line text lorem ipsum dolor sit amet, consectetur.",
            {},
            {})
    }
}