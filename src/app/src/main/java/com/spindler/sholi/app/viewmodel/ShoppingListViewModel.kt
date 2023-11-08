package com.spindler.sholi.app.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spindler.sholi.domain.model.ShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.CreateShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.CreateShoppingListArgs
import com.spindler.sholi.domain.usecase.shoppinglist.GetShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.UpdateShoppingList
import com.spindler.sholi.domain.usecase.shoppinglist.UpdateShoppingListArgs
import com.spindler.sholi.domain.util.ShoLiLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val createShoppingList: CreateShoppingList,
    private val updateShoppingList: UpdateShoppingList,
    private val getShoppingList: GetShoppingList
) : ViewModel() {

    private var _shoppingListId: String?

    init {
        _shoppingListId = savedStateHandle.get<String>("id")
        ShoLiLog.i(this, "init with shoppingListId=$_shoppingListId")

        if (_shoppingListId != null) {
            loadShoppingList(shoppingListId = _shoppingListId!!)
        }
    }

    private val _nameState = MutableStateFlow("")
    val nameState: StateFlow<String> = _nameState.asStateFlow()

    fun updateName(newName: String) {
        _nameState.value = newName
    }

    private fun updateFromShoppingList(shoppingList: ShoppingList) {
        updateName(shoppingList.name)
    }

    private fun loadShoppingList(shoppingListId: String) {
        viewModelScope.launch {
            val loaded = getShoppingList.invoke(shoppingListId).single()
            if (loaded == null) {
                ShoLiLog.i(
                    this,
                    "Couldn't find shopping list with id=$shoppingListId\n" +
                            "Creating empty shopping list."
                )
                _shoppingListId = null
            } else {
                updateFromShoppingList(loaded)
            }
        }
    }

    fun saveShoppingList(): Flow<ShoppingList> {
        val name = _nameState.value.trim()

        return if (_shoppingListId == null) {
            createShoppingList.invoke(
                CreateShoppingListArgs(name = name)
            )
        } else {
            updateShoppingList.invoke(
                UpdateShoppingListArgs(
                    id = _shoppingListId!!,
                    name = name,
                    isCompleted = false
                )
            )
        }
    }
}
