package com.spindler.sholi.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.GetShoppingLists
import com.spindler.sholi.domain.util.ShoLiLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getShoppingLists: GetShoppingLists
) : ViewModel() {

    private val _latestShoppingLists = MutableStateFlow(listOf<ShoppingList>())
    val latestShoppingLists: StateFlow<List<ShoppingList>> = _latestShoppingLists.asStateFlow()

    private fun getLatestShoppingLists(maximumCount: Int = 5) {
        viewModelScope.launch {
            val latest = getShoppingLists.invoke().single()
                .sortedByDescending { it.updatedOn }
                .take(maximumCount)

            _latestShoppingLists.value = latest
            ShoLiLog.i(this, "Got latest shopping lists (${latest.size})")
        }
    }

    init {
        ShoLiLog.i(this, "init")
        getLatestShoppingLists()
    }
}
