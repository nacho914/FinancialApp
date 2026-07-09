package com.vic.android.financialapp.ui.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vic.android.financialapp.domain.model.User
import com.vic.android.financialapp.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    val users = userRepository.getUsers()

    init {
        viewModelScope.launch {
            userRepository.insertUser(
                User(
                    id = "3",
                    name = "Victor nana"
                )
            )
        }
    }

}

