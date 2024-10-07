package com.example.app.testapp1.ui.screens._elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.app.testapp1.model.DeviceStatus

@Composable
fun StatusBar(
    currentStatus: DeviceStatus,
    onStatusChange: (status: DeviceStatus) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        DeviceStatus.entries.forEach { status ->
            item {
                OutlinedButton(
                    shape = RoundedCornerShape(20),
                    colors = ButtonDefaults.outlinedButtonColors().copy(
                        containerColor = if (status == currentStatus) Color.Gray
                        else ButtonDefaults.outlinedButtonColors().containerColor
                    ),
                    onClick = {
                        onStatusChange(status)
                    }
                ) {
                    Text(
                        text = status.status,
                        color = if (status == currentStatus) Color.White else Color.Blue
                    )
                }
            }
        }
    }
}