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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
                        VerticalSpacer(5.dp)
                        HorizontalDivider()
                        VerticalSpacer(5.dp)
                        if (deviceInfo.isNotEmpty()) {
                            LazyColumn(
                                contentPadding = PaddingValues(5.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                modifier = Modifier
                                    .weight(1f)
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
                                    .weight(1f)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    fontSize = 25.sp,
                                    color = Color.Gray,
                                    text = "No data"
                                )
                            }
                        }
                        VerticalSpacer(5.dp)
                        HorizontalDivider()
                        VerticalSpacer(5.dp)
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .padding(5.dp)
                                ) {
                                    if (currentDevice != null) {
                                        Text(
                                            fontSize = 23.sp,
                                            fontWeight = FontWeight.SemiBold,
                                            text = currentDevice?.name ?: "unknown"
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "Type: "
                                        )
                                        Text(
                                            text = currentDevice?.type ?: "unknown",
                                            modifier = Modifier.padding(start = 20.dp)
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "Status: "
                                        )
                                        Text(
                                            text = currentDevice?.status?.status ?: "unknown",
                                            modifier = Modifier.padding(start = 20.dp)
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "MAC: "
                                        )
                                        Text(
                                            text = currentDevice?.mac ?: "unknown",
                                            modifier = Modifier.padding(start = 20.dp)
                                        )
                                        Text(
                                            fontWeight = FontWeight.SemiBold,
                                            text = "Subscriptions: "
                                        )
                                        Text(
                                            text = currentDevice?.subscriptions ?: "unknown",
                                            modifier = Modifier.padding(start = 20.dp)
                                        )
                                    } else {
                                        Text(
                                            textAlign = TextAlign.Center,
                                            fontSize = 20.sp,
                                            color = Color.Gray,
                                            text = "No data",
                                        )
                                    }
                                }
                                HorizontalSpacer(10.dp)
                                Column {
                                    TextField(
                                        colors = TextFieldDefaults.colors().copy(
                                            focusedContainerColor = Color.White,
                                            unfocusedContainerColor = Color.White,
                                            focusedIndicatorColor = Color.White,
                                            unfocusedIndicatorColor = Color.White
                                        ),
                                        value = text,
                                        onValueChange = { newValue -> text = newValue },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f)
                                            .border(color = Color.Gray, width = 1.dp),

                                        singleLine = false
                                    )
                                    VerticalSpacer(5.dp)
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
                        VerticalSpacer(5.dp)
                        HorizontalDivider()
                        VerticalSpacer(5.dp)
                        BottomNavigationBar(navController = navController)
                    }
                }
            }
        }
    )
}