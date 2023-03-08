package com.example.coreUi.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.coreUi.R

@Composable
fun TestTextComponent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxHeight(0.5f)
            .fillMaxWidth()

    ) {
        Text(
            text = "bold",
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            //textAlign = TextAlign.End,
        textDecoration = TextDecoration.Underline
        )
        Text(
            text = "medium",
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            textDecoration = TextDecoration.None
            //textAlign = TextAlign.End,
        )
        Text(
            //text = "semi bold",
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    fontSize = 46.sp,
                    color = Color.Green,
                    fontFamily = FontFamily(Font(R.font.montserrat_thin))
                )) {
                    append("semi")
                }
                append("bold")
            },
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_semi_bold)),
            textDecoration = TextDecoration.LineThrough
            //textAlign = TextAlign.End,
        )
        Text(
            text = "regular",
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_regular)),
            //textAlign = TextAlign.End,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "light",
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_light)),
            //textAlign = TextAlign.End,
            textDecoration = TextDecoration.Underline
        )
        Text(
            text = "thin",
            fontSize = 32.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_thin)),
            //textAlign = TextAlign.End,
            textDecoration = TextDecoration.LineThrough
        )
    }
}

@Preview
@Composable
fun SamplesComponentPreview() {
    TestTextComponent()
}