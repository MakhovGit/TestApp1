package com.example.app.testapp1.ui.screens._elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.app.testapp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(screen: String) {
    TopAppBar(
        title = {
            Text(
                text = screen,
                textAlign = TextAlign.Start,
                fontSize = dimensionResource(id = R.dimen.top_bar_font_size).value.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }
    )
}