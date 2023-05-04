package com.example.appclinicaunmsm.presentacion.utils

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.appclinicaunmsm.R

@Preview
@Composable
fun TopBar() {
    TopAppBar(title = { Text(text = stringResource(R.string.app_name))})
}
