package com.example.coreUi.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//При вызове Composable функции система проверяет, поменялись ли входные параметры по
// сравнению с прошлым вызовом. Если не менялись, то нет смысла тратить ресурсы и время
// на вызов этой функции, потому что она покажет на экране то же самое, что уже показывает.

@Composable
fun CheckBoxTextFieldSample() {
    Log.d("TAG", "CheckBoxTextFieldSample")
    var check by remember { mutableStateOf(true) }
    doCheck(check) {
        check = it
    }
    recomposeSample()
}

@Composable
fun doCheck(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(
            "Some checkbox text",
            fontSize = 18.sp,
            modifier = Modifier.clickable {
                onCheckedChange.invoke(!checked)
            }
        )
    }
}

@Composable
fun doTextField(
    text: String,
    onValueChange: (String) -> Unit
) {
    Log.d("TAG", "doTextField")
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.padding(top = 68.dp)
        )
}

//Т.е. в комбинации remember + mutableStateOf, функция mutableStateOf создает State,
// а функция remember делает, так, чтобы этот State не сбрасывался при каждом перезапуске функции.
//У remember есть версия, которая способна сохранить значение даже при
// повороте экрана и завершении процесса. Это rememberSaveable.
@Composable
fun recomposeSample() {
    var textChanged by remember { mutableStateOf("") }
    Log.d("TAG", "recomposeSample")
    doTextField(textChanged) {
        textChanged = it
    }
}


@Preview
@Composable
fun CheckBoxTextFieldPreview() {
    CheckBoxTextFieldSample()
}