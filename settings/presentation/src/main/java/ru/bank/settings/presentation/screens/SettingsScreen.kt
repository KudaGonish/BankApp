package ru.bank.settings.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.collectLatest
import ru.bank.core_ui.reusableComponents.button.ButtonBack
import ru.bank.core_ui.reusableComponents.card.basic.CardClickState
import ru.bank.core_ui.reusableComponents.card.basic.CardWithContent
import ru.bank.core_ui.reusableComponents.icon.IconConfigured
import ru.bank.core_ui.reusableComponents.icon.IconRightArrow
import ru.bank.core_ui.reusableComponents.icon.ImageConfigured
import ru.bank.core_ui.reusableComponents.scaffold.ColumnDefaultScreen
import ru.bank.core_ui.reusableComponents.scaffold.ScaffoldDefault
import ru.bank.core_ui.reusableComponents.spacers.SpacerHorizontal
import ru.bank.core_ui.reusableComponents.spacers.SpacerVertical
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank
import ru.bank.core_ui.utils.PreviewContainerWithPaddingAndBorder
import ru.bank.settings.presentation.R


@Composable
internal fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    onNavigateToRegistrationForBankMember: () -> Unit,
    onNavigateToMappedListViewNavApi: () -> Unit,
    onReceiveUserId: () -> Int?,
) {

    val switchState by viewModel.switchState.collectAsStateWithLifecycle()

    val userInformation = viewModel.userInformation.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        onReceiveUserId()?.let {
            viewModel.fetchUserData(it)
        }
    }


    ScaffoldDefault { scaffoldState ->

        LaunchedEffect(Unit) {
            viewModel.messageForUi.collectLatest {
                scaffoldState.snackbarHostState.showSnackbar(it)
            }
        }

        ColumnDefaultScreen(topPadding = 5.dp) {

            ButtonBack(
                onClick = {
                    viewModel.sendSnackbar("Переход назад не доступен.")
                }
            )

            SpacerVertical(20.dp)

            TextOneFloor(
                text = userInformation.value.lastName,
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
            )

            SpacerVertical(5.dp)

            Row(verticalAlignment = Alignment.CenterVertically) {
                TextOneFloor(
                    text = userInformation.value.name,
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
                )

                SpacerHorizontal()

                IconConfigured(
                    resId = R.drawable.ic_note_pencil,
                    iconTint = MaterialTheme.colorsBank.textFiled.placeholder,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            viewModel.sendSnackbar("Изменение ФИО.")
                        }
                )

            }


            //Вместо номера телефона вывел номер из 16 цифр
            userInformation.value.memberNum.let {
                if (it.isNotBlank()) {

                    SpacerVertical(10.dp)

                    TextOneFloor(
                        color = MaterialTheme.colorsBank.text.description,
                        text = userInformation.value.memberNum.beautify(),
                        style = MaterialTheme.typography.caption
                    )

                }
            }

            SpacerVertical(10.dp)

            TextOneFloor(
                style = MaterialTheme.typography.caption,
                text = stringResource(id = R.string.my_purchases),
                color = MaterialTheme.colorsBank.text.description
            )

            SpacerVertical(8.dp)

            CardWithContent(
                cardClickState = CardClickState.Clickable(
                    isShowArrow = true,
                    onClick = onNavigateToMappedListViewNavApi

                )
            ) {
                ImageConfigured(
                    resId = R.drawable.ic_icon_stub,
                    modifier = Modifier
                        .size(35.dp)
                        .align(Alignment.CenterStart)
                        .clip(CircleShape)
                )
            }

            SpacerVertical(10.dp)

            TextOneFloor(
                style = MaterialTheme.typography.caption,
                text = stringResource(id = R.string.settings),
                color = MaterialTheme.colorsBank.text.description
            )

            SpacerVertical(8.dp)


            //email
            CardWithContent(
                cardClickState = CardClickState.Clickable(
                    isShowArrow = false,
                    onClick = {
                        viewModel.sendSnackbar("Ваш email.")
                    }
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    CardText(Modifier.weight(1f), stringResource(id = R.string.e_mail))

                    Column(horizontalAlignment = Alignment.Start) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End
                        ) {
                            //Хардкод текста, т.к ожидается что эти данные будут при регистрации
                            //задваться, но тут это не предусмотрено
                            TextOneFloor(
                                modifier = Modifier.padding(start = 5.dp),
                                style = MaterialTheme.typography.caption,
                                text = "kursantik341@gmail.com",
                                color = MaterialTheme.colorsBank.text.primary
                            )

                            SpacerHorizontal(5.dp)

                            IconRightArrow()
                        }

                        SpacerVertical(3.dp)

                        TextOneFloor(
                            modifier = Modifier.padding(start = 5.dp),
                            style = MaterialTheme.typography.overline,
                            text = stringResource(id = R.string.need_confirm),
                            color = MaterialTheme.colorsBank.text.error
                        )

                    }

                }

            }

            //Биометрия
            SpacerVertical(8.dp)

            CardWithContent(
                cardClickState = CardClickState.NotClickable
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    CardText(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.biometrics_login)
                    )

                    Switch(
                        checked = switchState,
                        onCheckedChange = {
                            viewModel.switchCheckedChange(it)
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = MaterialTheme.colorsBank.switch.thumb,
                            checkedTrackColor = MaterialTheme.colorsBank.switch.trackChecked,
                            uncheckedThumbColor = MaterialTheme.colorsBank.switch.thumb,
                            uncheckedTrackColor = MaterialTheme.colorsBank.switch.trackUnchecked,
                        )
                    )
                }
            }

            //Смена кода
            SpacerVertical(8.dp)

            CardWithContent(
                cardClickState = CardClickState.Clickable(
                    isShowArrow = true,
                    onClick = {
                        viewModel.sendSnackbar("Смена кода.")
                    }
                )
            ) {

                CardText(text = stringResource(id = R.string.name))

            }

            //Регистрация
            SpacerVertical(8.dp)

            CardWithContent(
                cardClickState = CardClickState.Clickable(
                    isShowArrow = true,
                    onClick = onNavigateToRegistrationForBankMember
                )
            ) {

                CardText(text = stringResource(id = R.string.register))

            }

            //Язык
            SpacerVertical(8.dp)

            CardWithContent(
                cardClickState = CardClickState.Clickable(
                    isShowArrow = true,
                    onClick = {
                        viewModel.sendSnackbar("Язык.")
                    }
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    CardText(text = stringResource(id = R.string.language))

                    TextOneFloor(
                        modifier = Modifier.padding(start = 5.dp),
                        style = MaterialTheme.typography.caption,
                        text = "русский",
                        color = MaterialTheme.colorsBank.text.primary
                    )

                }
            }


        }

    }

}

private fun String.beautify() =
    buildString {
        this@beautify.mapIndexed { index, char ->
            if (index % 4 == 0 && index != 0)
                this.append("$char ")
            else
                this.append(char)
        }
    }

@Composable
fun CardText(modifier: Modifier = Modifier, text: String) =
    TextOneFloor(
        modifier = modifier
            .padding(end = 5.dp),
        style = MaterialTheme.typography.caption,
        text = text,
        color = MaterialTheme.colorsBank.card.text
    )


@Preview
@Composable
private fun PreviewScreen() {
    PreviewContainerWithPaddingAndBorder {
        SettingsScreen(
            onNavigateToRegistrationForBankMember = {},
            onNavigateToMappedListViewNavApi = {},
            onReceiveUserId = { -1 })
    }
}
