package com.example.app.testapp1.ui.screens.messages_screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.app.testapp1.R
import com.example.app.testapp1.model.TextMessage
import com.example.app.testapp1.ui.screens._elements.BottomNavigationBar
import com.example.app.testapp1.ui.screens._elements.MessageItem
import com.example.app.testapp1.ui.screens._elements.TopBar
import com.example.app.testapp1.ui.screens._elements.VerticalSpacer
import com.example.app.testapp1.utils.EMPTY
import com.example.app.testapp1.utils.MAX_WEIGHT
import com.example.app.testapp1.utils.ONE
import org.koin.androidx.compose.koinViewModel
import java.time.Instant

@Composable
fun MessagesScreen(
    viewModel: MessagesScreenViewModel = koinViewModel(),
    navController: NavHostController
) {
    val currentUser = "Dmitrii"
    var isSendButtonEnabled by remember { mutableStateOf(false) }
    var messageText by remember { mutableStateOf(String.EMPTY) }
    var recipientText by remember { mutableStateOf(String.EMPTY) }
    val sentMessages = viewModel.screenState.data.filter { it.author == currentUser }
    val receivedMessages = viewModel.screenState.data.filter { it.recipient == currentUser }
    Scaffold(
        topBar = { TopBar("Messages") },
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
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(Float.MAX_WEIGHT)
                            ) {
                                Text(
                                    fontWeight = FontWeight.SemiBold,
                                    text = "Name: "
                                )
                                Text(
                                    text = currentUser
                                )
                            }
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.weight(Float.MAX_WEIGHT)
                            ) {
                                Text(
                                    fontWeight = FontWeight.SemiBold,
                                    text = "Period: "
                                )
                                Text(
                                    text = "Today"
                                )
                            }
                        }
                        HorizontalDivider()
                        Text(
                            fontWeight = FontWeight.SemiBold,
                            text = "Received"
                        )
                        LazyColumn(
                            contentPadding = PaddingValues(dimensionResource(R.dimen.common_padding_5)),
                            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.common_space_10)),
                            modifier = Modifier
                                .weight(Float.MAX_WEIGHT)
                                .fillMaxWidth()
                        ) {
                            receivedMessages.forEach { message ->
                                item {
                                    MessageItem(message = message, isSent = false)
                                }
                            }
                        }
                        HorizontalDivider()
                        Text(
                            fontWeight = FontWeight.SemiBold,
                            text = "Sent"
                        )
                        LazyColumn(
                            contentPadding = PaddingValues(dimensionResource(R.dimen.common_padding_5)),
                            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.common_space_10)),
                            modifier = Modifier
                                .weight(Float.MAX_WEIGHT)
                                .fillMaxWidth()
                        ) {
                            sentMessages.forEach { message ->
                                item {
                                    MessageItem(message = message, isSent = true)
                                }
                            }
                        }
                        HorizontalDivider()
                        Text(
                            fontWeight = FontWeight.SemiBold,
                            text = "New"
                        )
                        Box(
                            modifier = Modifier.weight(Float.MAX_WEIGHT)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        fontWeight = FontWeight.SemiBold,
                                        text = "Recipient: "
                                    )
                                    BasicTextField(
                                        value = recipientText,
                                        onValueChange = { newValue ->
                                            recipientText = newValue
                                            isSendButtonEnabled =
                                                messageText.isNotBlank() && recipientText.isNotBlank()
                                        },
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
                                        singleLine = true
                                    )
                                }
                                VerticalSpacer(dimensionResource(R.dimen.common_space_5))
                                BasicTextField(
                                    value = messageText,
                                    onValueChange = { newValue ->
                                        messageText = newValue
                                        isSendButtonEnabled =
                                            messageText.isNotBlank() && recipientText.isNotBlank()
                                    },
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
                                OutlinedButton(
                                    shape = RoundedCornerShape(10),
                                    enabled = isSendButtonEnabled,
                                    onClick = {
                                        if (recipientText.isNotBlank() && messageText.isNotBlank()) {
                                            val newMessage = TextMessage(
                                                id = viewModel.screenState.data.first().id + Int.ONE,
                                                dateTime = Instant.now().toEpochMilli(),
                                                author = currentUser,
                                                recipient = recipientText,
                                                text = messageText
                                            )
                                            viewModel.handleEvent(
                                                MessagesScreenContract.Event.SaveMessage(
                                                    message = newMessage
                                                )
                                            )
                                            recipientText = String.EMPTY
                                            messageText = String.EMPTY
                                            isSendButtonEnabled = false
                                        }
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        color = Color.Blue,
                                        text = "Send"
                                    )
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