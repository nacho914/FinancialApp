package com.vic.android.financialapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vic.android.financialapp.ui.theme.Background
import com.vic.android.financialapp.ui.theme.Border
import com.vic.android.financialapp.ui.theme.CardBackground
import com.vic.android.financialapp.ui.theme.Dimens.ButtonHeight
import com.vic.android.financialapp.ui.theme.Dimens.CardRadius
import com.vic.android.financialapp.ui.theme.Dimens.IconLarge
import com.vic.android.financialapp.ui.theme.Dimens.IconXLarge
import com.vic.android.financialapp.ui.theme.Dimens.ProfileAvatarSize
import com.vic.android.financialapp.ui.theme.Dimens.Space16
import com.vic.android.financialapp.ui.theme.Dimens.Space24
import com.vic.android.financialapp.ui.theme.Dimens.Space32
import com.vic.android.financialapp.ui.theme.Dimens.Space8
import com.vic.android.financialapp.ui.theme.Dimens.ThinBorder
import com.vic.android.financialapp.ui.theme.Dimens.UserAvatarSize
import com.vic.android.financialapp.ui.theme.FinancialAppTheme
import com.vic.android.financialapp.ui.theme.Primary
import com.vic.android.financialapp.ui.theme.PrimaryLight
import com.vic.android.financialapp.ui.theme.Surface
import com.vic.android.financialapp.ui.theme.TextPrimary
import com.vic.android.financialapp.ui.theme.TextSecondary

@Composable
fun UserScreen(
    navController: NavHostController,
    users: List<UserUi>,
    onUserClick: (UserUi) -> Unit,
    onAddUserClick: () -> Unit,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors =
                            listOf(
                                Background,
                                Surface,
                                Background,
                            ),
                    ),
                )
                .padding(horizontal = Space24),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(ButtonHeight))

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
            text = "Select a user",
            color = TextPrimary,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(Space8))

        Text(
            text = "Choose a user to continue",
            color = TextSecondary,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(Space32))

        Card(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(1f),
            shape = RoundedCornerShape(Space32),
            colors =
                CardDefaults.cardColors(
                    containerColor = Surface,
                ),
            border = BorderStroke(ThinBorder, Border),
        ) {
            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(Space16),
                verticalArrangement = Arrangement.spacedBy(Space16),
            ) {
                items(users) { user ->
                    UserCard(
                        user = user,
                        onClick = { onUserClick(user) },
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(Space24))

        Button(
            onClick = onAddUserClick,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(ButtonHeight)
                    .padding(bottom = Space24),
            shape = RoundedCornerShape(CardRadius),
            colors =
                ButtonDefaults.buttonColors(
                    containerColor = Primary,
                ),
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = TextPrimary,
            )

            Spacer(modifier = Modifier.width(Space8))

            Text(
                text = "Add new user",
                color = TextPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Composable
fun UserCard(
    user: UserUi,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors =
            CardDefaults.cardColors(
                containerColor = CardBackground,
            ),
        shape = RoundedCornerShape(CardRadius),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(Space16),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier =
                    Modifier
                        .size(UserAvatarSize)
                        .clip(CircleShape)
                        .background(Border),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = PrimaryLight,
                    modifier = Modifier.size(IconLarge),
                )
            }

            Spacer(modifier = Modifier.width(Space16))

            Text(
                text = user.name,
                color = TextPrimary,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
            )
        }
    }
}

data class UserUi(
    val id: String,
    val name: String,
)

@Preview
@Composable
fun UserScreenPreview() {
    FinancialAppTheme {
        UserScreen(
            navController = rememberNavController(),
            users =
                listOf(
                    UserUi("1", "Victor"),
                    UserUi("2", "Maria"),
                    UserUi("3", "Juan"),
                ),
            onUserClick = {},
            onAddUserClick = {},
        )
    }
}
