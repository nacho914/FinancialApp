package com.vic.android.financialapp.ui.screens.addUser

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.vic.android.financialapp.ui.theme.Background
import com.vic.android.financialapp.ui.theme.Border
import com.vic.android.financialapp.ui.theme.CardBackground
import com.vic.android.financialapp.ui.theme.Dimens.ButtonHeight
import com.vic.android.financialapp.ui.theme.Dimens.CardRadius
import com.vic.android.financialapp.ui.theme.Dimens.IconXLarge
import com.vic.android.financialapp.ui.theme.Dimens.ProfileAvatarSize
import com.vic.android.financialapp.ui.theme.Dimens.Space16
import com.vic.android.financialapp.ui.theme.Dimens.Space24
import com.vic.android.financialapp.ui.theme.Dimens.Space32
import com.vic.android.financialapp.ui.theme.Primary
import com.vic.android.financialapp.ui.theme.PrimaryLight
import com.vic.android.financialapp.ui.theme.Surface
import com.vic.android.financialapp.ui.theme.TextPrimary
import com.vic.android.financialapp.ui.theme.TextSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(
    navController: NavHostController,
    viewModel: AddUserViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "New User",
                        color = TextPrimary,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = TextPrimary,
                        )
                    }
                },
                colors =
                    TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = Background,
                    ),
            )
        },
    ) { padding ->

        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Background,
                                Surface,
                                Background,
                            ),
                        ),
                    ).padding(padding)
                    .padding(horizontal = Space24),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(Space32))

            Box(
                modifier =
                    Modifier
                        .size(ProfileAvatarSize)
                        .clip(CircleShape)
                        .background(CardBackground),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = PrimaryLight,
                    modifier = Modifier.size(IconXLarge),
                )
            }

            Spacer(modifier = Modifier.height(Space24))

            Text(
                text = "Create User",
                color = TextPrimary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(Space16))

            Text(
                text = "Enter the user's information",
                color = TextSecondary,
                fontSize = 16.sp,
            )

            Spacer(modifier = Modifier.height(Space32))

            OutlinedTextField(
                value = uiState.firstName,
                onValueChange = viewModel::onFirstNameChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("First Name")
                },
                singleLine = true,
                colors =
                    OutlinedTextFieldDefaults.colors(
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary,
                        cursorColor = Primary,
                        focusedBorderColor = Primary,
                        unfocusedBorderColor = Border,
                        focusedLabelColor = Primary,
                        unfocusedLabelColor = TextSecondary,
                    ),
            )

            Spacer(modifier = Modifier.height(Space16))

            OutlinedTextField(
                value = uiState.lastName,
                onValueChange = viewModel::onLastNameChange,
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Last Name")
                },
                singleLine = true,
                colors =
                    OutlinedTextFieldDefaults.colors(
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary,
                        cursorColor = Primary,
                        focusedBorderColor = Primary,
                        unfocusedBorderColor = Border,
                        focusedLabelColor = Primary,
                        unfocusedLabelColor = TextSecondary,
                    ),
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    viewModel.saveUser()
                },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(ButtonHeight),
                shape = RoundedCornerShape(CardRadius),
                colors =
                    ButtonDefaults.buttonColors(
                        containerColor = Primary,
                    ),
            ) {
                Text(
                    text = "Save User",
                    color = TextPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }

            Spacer(modifier = Modifier.height(Space24))
        }
    }

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                AddUserEvent.UserSaved -> {
                    navController.popBackStack()
                }
            }
        }
    }
}
