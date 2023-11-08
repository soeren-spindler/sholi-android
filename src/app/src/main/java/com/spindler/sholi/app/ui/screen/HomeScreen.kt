package com.spindler.sholi.app.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.spindler.sholi.domain.util.ShoLiLog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSettingsClicked: () -> Unit,
    onCreateShoppingListClicked: () -> Unit,
    onNavigateToShoppingList: (id: String) -> Unit
) {
    ShoLiLog.i("HomeScreen", "recompose HomeScreen")

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Shopping List") },
                actions = {
                    IconButton(
                        onClick = { onSettingsClicked() }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Open settings"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Shopping List") },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Create a new shopping list"
                    )
                },
                onClick = { onCreateShoppingListClicked() }
            )
        }
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues),
            onCreateShoppingList = onCreateShoppingListClicked,
            onNavigateToShoppingList = onNavigateToShoppingList
        )
    }
}
