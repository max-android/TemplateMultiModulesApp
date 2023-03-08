package com.example.coreUi.components

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Dimension
import com.example.coreUi.R

//Если мы хотим задать атрибут, специфичный для элемента, то он будет в параметрах функции.
// Примеры: text и fontSize. Такие атрибуты встречаются далеко не у всех элементов.
// Они специфичны для элемента Text.
//А если нам надо задать атрибут, который можно применить практически к любому элементу,
// то они будут в Modifier. Примеры: width и background.
//В итоге для настройки элементов мы будем использовать и параметры функции и Modifier.

@Composable
fun BaseText() {
    Text(
        text = "Home screen",
        fontSize = 32.sp,
        color = Color.White,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.DarkGray)
            // .width(500.dp)
            //.height(300.dp)
            .fillMaxWidth()
    )
}

//Column занимает места ровно столько, чтобы вместить два текста.
// Т.е. по умолчанию работает в режиме wrap_content.

//verticalArrangement = Arrangement.SpaceEvenly - текст располагается равномерно с расстояниями между

//verticalArrangement = Arrangement.SpaceBetween -
// текст располагается равномерно + с равном отступом вверху и внизу

@Composable
fun BaseColumn() {
    Column(
        //horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(color = Color.DarkGray)
                .fillMaxWidth()
        ) {
            Text(text = "Title", fontSize = 32.sp)
            Text(text = "Description", fontSize = 20.sp)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .background(color = Color.DarkGray)
                .fillMaxWidth()
        ) {
            Text(
                text = "Title-2",
                fontSize = 32.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Description-2", fontSize = 20.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }

        BaseRaw1()
        BaseRaw2()
        BaseRaw3()
        BaseRaw4()
        BaseBox()
        Combine()
    }
}

@Composable
fun BaseRaw1() {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Name", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(24.dp))
        Text(text = "Surname", fontSize = 20.sp)
    }

}

@Composable
fun BaseRaw2() {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Name", fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        //Spacer(modifier = Modifier.weight(1f, false))
        Text(
            text = "Surname", fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }

}

@Composable
fun BaseRaw3() {

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "Name", fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Text(
            text = "Surname", fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }

}

@Composable
fun BaseRaw4() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.SpaceBetween,
        //horizontalArrangement = Arrangement.SpaceEvenly,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Name-1", fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Name-2", fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Name-3", fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BaseBox() {
    Box(
        modifier = Modifier
            .padding(top = 56.dp)
            .fillMaxWidth()
            .background(color = Color.Yellow)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(128.dp)
                .height(128.dp).align(Alignment.BottomCenter),
        )
        Text(text = "text-start", fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterStart)
        )
        Text(text = "text-end", fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun Combine() {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 56.dp)) {
        Box {
            Text("N", fontSize = 48.sp)
            Text("ame", modifier = Modifier.align(Alignment.BottomCenter))
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text("Title")
            Text("Description")
        }
    }
}

//Ресурсы
//Я для простоты примеров продолжу использовать числа и строки напрямую в коде.
// Но в реальном приложении мы обычно используем string и dimen ресурсы.
// Для этого есть функции stringResource и dimensionResource:


@Preview
@Composable
fun BasePreview() {
    //BaseText()
    BaseColumn()
}