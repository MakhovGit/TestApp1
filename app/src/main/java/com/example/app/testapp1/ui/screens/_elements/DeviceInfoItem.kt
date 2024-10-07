package com.example.app.testapp1.ui.screens._elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.testapp1.model.DeviceInfo

@Composable
fun DeviceInfoItem(
    info: DeviceInfo,
    onClick: (deviceInfo: DeviceInfo) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(20),
        border = BorderStroke(1.dp, Color.Gray),
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick(info)
            }
    ) {
        val fontSize = 12.sp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Name: "
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Type: "
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Status: "
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "MAC: "
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Subscriptions: "
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 10.dp)
                ) {
                    Text(
                        fontSize = fontSize,
                        text = info.name
                    )
                    Text(
                        fontSize = fontSize,
                        text = info.type
                    )
                    Text(
                        fontSize = fontSize,
                        text = info.status.status
                    )
                    Text(
                        fontSize = fontSize,
                        text = info.mac
                    )
                    Text(
                        fontSize = fontSize,
                        text = info.subscriptions
                    )
                }
            }
        }
    }
}