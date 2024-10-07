package com.example.app.testapp1.ui.screens._elements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.testapp1.R
import com.example.app.testapp1.model.TextMessage
import com.example.app.testapp1.utils.MAX_WEIGHT
import com.example.app.testapp1.utils.ONE
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun MessageItem(message: TextMessage, isSent: Boolean) {
    Surface(
        shape = RoundedCornerShape(20),
        border = BorderStroke(Int.ONE.dp, Color.Gray),
        modifier = Modifier.fillMaxSize()
    ) {
        val localDateTime =
            LocalDateTime.ofInstant(Instant.ofEpochMilli(message.dateTime), ZoneId.systemDefault())
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val formattedDate = localDateTime.format(dateFormatter)
        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")
        val formattedTime = localDateTime.format(timeFormatter)
        val fontSize = dimensionResource(R.dimen.message_item_font_size).value.sp
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.common_padding_5))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Id:"
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Date:"
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(Float.MAX_WEIGHT)
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontSize = fontSize,
                        text = message.id.toString()
                    )
                    Text(
                        fontSize = fontSize,
                        text = formattedDate
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = if (isSent) "Recipient:" else "Author:"
                    )

                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Time:"
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(Float.MAX_WEIGHT)
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontSize = fontSize,
                        text = if (isSent) message.recipient else message.author
                    )
                    Text(
                        fontSize = fontSize,
                        text = formattedTime
                    )
                }
            }
            HorizontalDivider()
            Text(
                fontSize = fontSize,
                text = message.text,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
            )
        }
    }
}