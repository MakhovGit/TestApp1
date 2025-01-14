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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.testapp1.R
import com.example.app.testapp1.model.DeviceInfo
import com.example.app.testapp1.utils.MAX_WEIGHT
import com.example.app.testapp1.utils.ONE

@Composable
fun DeviceInfoItem(
    info: DeviceInfo,
    onClick: (deviceInfo: DeviceInfo) -> Unit
) {
    Surface(
        shape = RoundedCornerShape(20),
        border = BorderStroke(Int.ONE.dp, Color.Gray),
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick(info)
            }
    ) {
        val fontSize = dimensionResource(R.dimen.device_info_item_font_size).value.sp
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
                        text = "Name:"
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Status:"
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(Float.MAX_WEIGHT)
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontSize = fontSize,
                        text = info.name
                    )
                    Text(
                        fontSize = fontSize,
                        text = info.status.status
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "Type:"
                    )
                    Text(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = fontSize,
                        text = "MAC:"
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(Float.MAX_WEIGHT)
                        .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
                ) {
                    Text(
                        fontSize = fontSize,
                        text = info.type
                    )
                    Text(
                        fontSize = fontSize,
                        text = info.mac
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.common_padding_10))
            ) {
                Text(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = fontSize,
                    text = "Subscriptions:"
                )
                HorizontalSpacer(dimensionResource(R.dimen.common_padding_5))
                Text(
                    fontSize = fontSize,
                    text = info.subscriptions
                )
            }
        }
    }
}