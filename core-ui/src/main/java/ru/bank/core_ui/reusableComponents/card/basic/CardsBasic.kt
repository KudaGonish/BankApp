package ru.bank.core_ui.reusableComponents.card.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bank.core_ui.R
import ru.bank.core_ui.reusableComponents.icon.IconRightArrow
import ru.bank.core_ui.reusableComponents.spacers.SpacerHorizontal
import ru.bank.core_ui.reusableComponents.texts.TextOneFloor
import ru.bank.core_ui.theme.colorsBank
import ru.bank.core_ui.utils.PreviewContainerWithPaddingAndBorder

/**
 * Родительский компонент карточки.
 * Использутется как контейнер для всех остальных карточек примененных в проекте.
 * @param modifier по стандарту заданы минимальная(130) и максимальная(580) ширина. Минимальная(44) высота
 * @param shape скругление для карточки
 * @param elevation тень карточки
 * @param cardMinHeight минимальная высота(44)
 * @param background цвет контейнера внутри карточки(для корректного отображения цвета в темной теме)
 * @param borderDefaultColor цвет границы карточки по умолчанию
 * @param borderErrorColor цвет границы карточки в состоянии ошибки
 * @param isErrorBordersVisible отоброжение обводки обозначающий ошибку
 */
@Composable
fun CardBasicContainer(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(4.dp),
    elevation: Dp = 6.dp,
    cardMinHeight: Dp = 44.dp,
    background: Color = MaterialTheme.colorsBank.card.background,
    borderDefaultColor: Color = Color.Transparent,
    isErrorBordersVisible: Boolean = false,
    content: @Composable () -> Unit
) {
    Card(
        shape = shape,
        modifier = modifier
            .widthIn(min = 130.dp, max = 580.dp)
            .heightIn(min = cardMinHeight),
        elevation = elevation,
        backgroundColor = Color.Transparent
    ) {
        // прослойка для исключения влияния elevation на тон background
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(background),
            contentAlignment = Alignment.Center
        ) { content() }
    }
}


/**
 * Базовая карточка.
 * Карточка не имеет отсутпов сверху, контент распологает по центру
 * @param shape фигура карточки. По стандарту со скошеными углами в 4.dp
 * @param elevation тень, по стандарту 6.dp
 * @param cardMinHeight минимальная высота карточки, по стандарту 44.dp
 * @param background бэкграунд карточки(цвет не пересчитывается в темной теме исходя из elevation)
 * @param cardClickState состояние кликабельности. Если кликабельная, появляется навигационная
 * стрелка справа карточки.
 * @param isErrorBordersVisible состояние выделения карточки красной обводкой
 * @param allContentPadding отступ для всего контента в карточке (включая нав. стрелку)
 * @param topContent контент находящийся выше контейнера со стрелкой.
 * @param content основной контент карточки
 */
@Composable
fun CardWithContent(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    elevation: Dp = 6.dp,
    cardMinHeight: Dp = 60.dp,
    background: Color = MaterialTheme.colorsBank.card.background,
    cardClickState: CardClickState = CardClickState.Clickable(isShowArrow = true) { },
    allContentPadding: PaddingValues = PaddingValues(horizontal = 15.dp),
    topContent: (@Composable ColumnScope.() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit
) {

    CardBasicContainer(
        modifier = if (cardClickState is CardClickState.Clickable) {
            modifier.clip(shape).clickable(onClick = cardClickState.onClick)
        } else {
            modifier
        },
        shape = shape,
        elevation = elevation,
        cardMinHeight = cardMinHeight,
        background = background,
        content = {

            Column(
                modifier = Modifier.padding(allContentPadding),
            ) {

                if (topContent != null) topContent()

                val isShowArrow: Boolean = remember(key1 = cardClickState) {
                    if (cardClickState is CardClickState.Clickable) cardClickState.isShowArrow
                    else false
                }

                if (isShowArrow) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(modifier = Modifier.weight(1f)) { content() }
                        SpacerHorizontal(5.dp)
                        IconRightArrow()
                    }
                } else {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) { content() }
                }
            }
        }
    )
}



@Preview(widthDp = 360)
//@Preview(widthDp = 896)
@Composable
private fun CardBasicContainerPreview() {
    PreviewContainerWithPaddingAndBorder() {
        CardWithContent(
            topContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextOneFloor(text = "topContent topContent topContent topContent topContent topContent topContent")
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextOneFloor(text = "content content content content content content content content content content")
                }
            }
        )
    }
}


@Preview(widthDp = 360)
@Composable
private fun CardWithContentPreview() {
    PreviewContainerWithPaddingAndBorder() {
        CardWithContent(
            topContent = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextOneFloor(text = "topContent")
                    TextOneFloor(text = "topContent")
                    TextOneFloor(text = "topContent")
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    TextOneFloor(text = "content")
                    TextOneFloor(text = "content")
                    TextOneFloor(text = "content")
                }
            }
        )
    }
}
