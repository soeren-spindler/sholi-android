package com.spindler.sholi.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.spindler.sholi.app.ui.composable.ShoppingListsColumn
import com.spindler.sholi.app.viewmodel.HomeViewModel
import com.spindler.sholi.domain.util.ShoLiLog

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    onCreateShoppingList: () -> Unit,
    onNavigateToShoppingList: (id: String) -> Unit
) {
    ShoLiLog.i("HomeScreenContent", "recompose HomeScreenContent")

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        val latestShoppingLists by homeViewModel.latestShoppingLists.collectAsStateWithLifecycle()
        if (latestShoppingLists.isEmpty()) {
            Button(
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(top = 24.dp),
                onClick = { onCreateShoppingList() }
            ) {
                Text(text = "Create a shopping list")
            }
        } else {
            ShoppingListsColumn(
                shoppingLists = latestShoppingLists,
                onNavigateToShoppingList = onNavigateToShoppingList
            )
        }
    }
}
