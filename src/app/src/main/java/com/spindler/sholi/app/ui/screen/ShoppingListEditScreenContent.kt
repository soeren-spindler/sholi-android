package com.spindler.sholi.app.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.spindler.sholi.app.viewmodel.ShoppingListViewModel

@Composable
fun ShoppingListEditScreenContent(
    modifier: Modifier = Modifier,
    shoppingListViewModel: ShoppingListViewModel
) {
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(
                top = 18.dp,
                bottom = 8.dp,
                start = 8.dp,
                end = 8.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val name by shoppingListViewModel.nameState.collectAsStateWithLifecycle()
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = name,
                onValueChange = { shoppingListViewModel.updateName(it) },
                singleLine = true
            )
            //ShoppingListItemsColumn()
        }
    }
}
