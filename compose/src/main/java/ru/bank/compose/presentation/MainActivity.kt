package ru.bank.compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import dagger.hilt.android.AndroidEntryPoint
import ru.bank.compose.presentation.navigation.MainNavigation
import ru.bank.core_ui.theme.BankTheme

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        setContent {
            BankTheme { MainNavigation() }
        }

        super.onCreate(savedInstanceState)
    }


}


