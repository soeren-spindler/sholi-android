package com.spindler.sholi.app.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.spindler.sholi.domain.model.ShoppingList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListsColumn(
    shoppingLists: List<ShoppingList>,
    onNavigateToShoppingList: (id: String) -> Unit = {},
    itemSpacing: Dp = 0.dp
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(itemSpacing)
    ) {
        items(
            items = shoppingLists,
            key = { it.id }
        ) { shoppingList ->
            Card(
                onClick = { onNavigateToShoppingList(shoppingList.id.toString()) }
            ) {
                Text(text = "${shoppingList.name} - ${shoppingList.isCompleted}")
            }
        }
    }
}
