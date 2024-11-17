package com.example.lab6_1.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.lab6_1.api.fetchUsers
import com.example.lab6_1.model.User


class UserViewModel : ViewModel() {
    var userList by mutableStateOf<List<User>>(emptyList())
    var errorMessage by mutableStateOf("")
    var isLoading = mutableStateOf(false)

    init {
        fetchUserList()
    }

    fun fetchUserList() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                userList = fetchUsers()

            } catch (e: Exception) {
                Log.d("errorMessage", e.message.toString())
                errorMessage = "Failed to load data: ${e.message}"
            }
            finally {
                isLoading.value = false
            }
        }
    }
}