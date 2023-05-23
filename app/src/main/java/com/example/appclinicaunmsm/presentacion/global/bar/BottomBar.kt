package com.example.appclinicaunmsm.presentacion.global.bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appclinicaunmsm.R
import com.example.appclinicaunmsm.presentacion.navigation.AppScreens

@Composable
fun BottomBar(navController: NavController) {
    val bottomNavBarStrings = stringArrayResource(id = R.array.bottom_bar)

    val navBarItems = arrayOf(
        Pair(bottomNavBarStrings[0], Icons.Outlined.Home),
        Pair(bottomNavBarStrings[1], Icons.Outlined.AccountCircle),
        Pair(bottomNavBarStrings[2], Icons.Outlined.Info),
        Pair(bottomNavBarStrings[3], Icons.Outlined.Settings),
    )

    BottomAppBar(content = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            SectionBottomBar(
                text = navBarItems[0].first,
                imageVector = navBarItems[0].second,
                onClick = { navController.navigate(AppScreens.HOME_SCREEN.route) }
            )
            SectionBottomBar(
                text = navBarItems[1].first,
                imageVector = navBarItems[1].second,
                onClick = { navController.navigate(AppScreens.APPOINTMENT_SCREEN.route) }
            )
            SectionBottomBar(
                text = navBarItems[2].first,
                imageVector = navBarItems[2].second,
                onClick = { navController.navigate(AppScreens.HOME_SCREEN.route) }
            )
            SectionBottomBar(
                text = navBarItems[3].first,
                imageVector = navBarItems[3].second,
                onClick = { navController.navigate(AppScreens.HOME_SCREEN.route) }
            )
        }
    })
}

@Composable
fun SectionBottomBar(text: String, imageVector: ImageVector, onClick: () -> Unit, ) {
    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(modifier = Modifier.size(20.dp), onClick = onClick ) {
            Icon(
                imageVector = imageVector,
                contentDescription = "dummy",
            )
        }
        Text(
            fontSize = 12.sp, text = text
        )
    }
}