package com.vic.android.financialapp.ui.screens.addUser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vic.android.financialapp.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AddUserViewModel
    @Inject
    constructor(
        private val repository: UserRepository,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(AddUserUiState())
        val uiState = _uiState.asStateFlow()

        private val _events = MutableSharedFlow<AddUserEvent>()
        val events = _events.asSharedFlow()

        fun onFirstNameChange(firstName: String) {
            _uiState.value =
                _uiState.value.copy(
                    firstName = firstName,
                )
        }

        fun onLastNameChange(lastName: String) {
            _uiState.value =
                _uiState.value.copy(
                    lastName = lastName,
                )
        }

        fun saveUser() {
            val state = _uiState.value

            if (state.firstName.isBlank() || state.lastName.isBlank()) {
                return
            }

            viewModelScope.launch {
                repository.insertUser(
                    firstName = state.firstName.trim(),
                    lastName = state.lastName.trim(),
                )
                _events.emit(AddUserEvent.UserSaved)
            }
        }
    }
