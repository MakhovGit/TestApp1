package com.example.app.testapp1.ui.screens.devs_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app.testapp1.R
import com.example.app.testapp1.model.DeviceInfo
import com.example.app.testapp1.model.DeviceStatus
import com.example.app.testapp1.ui.screens._elements.BottomNavigationBar
import com.example.app.testapp1.ui.screens._elements.DeviceInfoItem
import com.example.app.testapp1.ui.screens._elements.HorizontalSpacer
import com.example.app.testapp1.ui.screens._elements.StatusBar
import com.example.app.testapp1.ui.screens._elements.TopBar
import com.example.app.testapp1.ui.screens._elements.VerticalSpacer
import com.example.app.testapp1.utils.EMPTY
import com.example.app.testapp1.utils.MAX_WEIGHT
import com.example.app.testapp1.utils.ONE
import org.koin.androidx.compose.koinViewModel

@Composable
fun DevsScreen(
    viewModel: DevsScreenViewModel = koinViewModel(),
    navController: NavHostController
) {
    var text by remember { mutableStateOf(String.EMPTY) }
    var currentStatus by remember { mutableStateOf(DeviceStatus.ALL) }
    var currentDevice: DeviceInfo? by remember { mutableStateOf(null) }
    val deviceInfo = if (currentStatus == DeviceStatus.ALL)
        viewModel.screenState.data
    else
        viewModel.screenState.data.filter { it.status == currentStatus }
    Scaffold(
        topBar = { TopBar("Devices List") },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(dimensionResource(R.dimen.common_padding_10))
                    ) {
                        StatusBar(
                            currentStatus = currentStatus,
                            onStatusChange = { status ->
                                currentStatus = status
                            }
                        )
                        VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                        HorizontalDivider()
                        VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                        if (deviceInfo.isNotEmpty()) {
                            LazyColumn(
                                contentPadding = PaddingValues(dimensionResource(R.dimen.common_padding_5)),
                                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.common_space_10)),
                                modifier = Modifier
                                    .weight(Float.MAX_WEIGHT)
                                    .fillMaxWidth()
                            ) {
                                deviceInfo.forEach { info ->
                                    item {
                                        DeviceInfoItem(info, onClick = { deviceInfo ->
                                            currentDevice = deviceInfo
                                        })
                                    }
                                }
                            }
                        } else {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .weight(Float.MAX_WEIGHT)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    fontSize = dimensionResource(R.dimen.devs_screen_big_no_data_font_size).value.sp,
                                    color = Color.Gray,
                                    text = "No data"
                                )
                            }
                        }
                        VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                        HorizontalDivider()
                        VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(Float.MAX_WEIGHT)
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(dimensionResource(R.dimen.common_padding_5))
                                ) {
                                    if (currentDevice != null) {
                                        Text(
                                            fontSize = dimensionResource(R.dimen.devs_screen_device_name_font_size).value.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            text = currentDevice?.name ?: "unknown"
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "Type: "
                                        )
                                        Text(
                                            text = currentDevice?.type ?: "unknown",
                                            modifier = Modifier.padding(start = dimensionResource(R.dimen.common_padding_20))
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "Status: "
                                        )
                                        Text(
                                            text = currentDevice?.status?.status ?: "unknown",
                                            modifier = Modifier.padding(start = dimensionResource(R.dimen.common_padding_20))
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "MAC: "
                                        )
                                        Text(
                                            text = currentDevice?.mac ?: "unknown",
                                            modifier = Modifier.padding(start = dimensionResource(R.dimen.common_padding_20))
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "Subscriptions: "
                                        )
                                        Text(
                                            text = currentDevice?.subscriptions ?: "unknown",
                                            modifier = Modifier.padding(start = dimensionResource(R.dimen.common_padding_20))
                                        )
                                    } else {
                                        Text(
                                            textAlign = TextAlign.Center,
                                            fontSize = dimensionResource(R.dimen.devs_screen_little_no_data_font_size).value.sp,
                                            color = Color.Gray,
                                            text = "No data",
                                        )
                                    }
                                }
                                HorizontalSpacer(dimensionResource(R.dimen.common_space_10))
                                Column {
                                    BasicTextField(
                                        value = text,
                                        onValueChange = { newValue -> text = newValue },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(Float.MAX_WEIGHT)
                                            .border(color = Color.Gray, width = Int.ONE.dp),
                                        decorationBox = { innerTextField ->
                                            Box(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(dimensionResource(R.dimen.common_text_field_padding))
                                            ) {
                                                innerTextField()
                                            }
                                        },
                                        singleLine = false
                                    )
                                    VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                                    OutlinedButton(
                                        shape = RoundedCornerShape(10),
                                        onClick = { },
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            color = Color.Blue,
                                            text = "Send"
                                        )
                                    }
                                }
                            }
                        }
                        VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                        HorizontalDivider()
                        VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                        BottomNavigationBar(navController = navController)
                    }
                }
            }
        }
    )
}