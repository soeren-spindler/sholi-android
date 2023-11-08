package com.spindler.sholi.app.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.spindler.sholi.app.viewmodel.ShoppingListViewModel
import com.spindler.sholi.domain.util.ShoLiLog
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListEditScreen(
    shoppingListViewModel: ShoppingListViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateAfterSaved: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Shopping List") },
                navigationIcon = {
                    IconButton(onClick = { onNavigateBack() }) {
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "Close shopping list and go back to home"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            val saved = shoppingListViewModel.saveShoppingList().single()
                            ShoLiLog.i("ShoppingListEditScreen", "saved: ${saved.id}")
                            onNavigateAfterSaved()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = "Save this shopping list and go back to home"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        ShoppingListEditScreenContent(
            modifier = Modifier.padding(paddingValues),
            shoppingListViewModel = shoppingListViewModel
        )
    }
}
