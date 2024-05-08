package net.ezra.ui.settings


import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_HOMES
import net.ezra.R
import net.ezra.navigation.ROUTE_APART
import net.ezra.navigation.ROUTE_BUNGALOW
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_RANCH
import net.ezra.navigation.ROUTE_VILLA
import net.ezra.ui.contact.ContactScreen

@Composable
fun SettingsSection(
    modifier: Modifier = Modifier,
    onThemeChange: () -> Unit,
    onLogout: () -> Unit
) {
    Column(modifier = modifier.padding(all = 16.dp)) {
        SettingItem(
            icon = Icons.Filled.Settings,
            title = "Dark Mode",
            subtitle = "Toggle dark mode on/off",
            onClick = onThemeChange
        )

        Spacer(modifier = Modifier.height(8.dp))

        SettingItem(
            icon = Icons.Filled.Notifications,
            title = "Notifications",
            subtitle = "Configure notification settings",
            onClick = {}
        )

        Spacer(modifier = Modifier.height(8.dp))

        SettingItem(
            icon = Icons.Filled.PlayArrow,
            title = "Logout",
            subtitle = "Logout from the app",
            onClick = onLogout
        )
    }
}

@Composable
private fun SettingItem(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.clickable(onClick = onClick)) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}