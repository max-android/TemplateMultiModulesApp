package com.example.featureProfile.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.common.R
import com.example.coreUi.Black

@Composable
fun EditProfileItem() {

    ConstraintLayout(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(
                color = colorResource(id = R.color.white)
            )
            .fillMaxWidth()
            .wrapContentHeight()

    ) {
        val (
            titleEditProfile, imagePhone, valuePhone, viewEditProfile, spacerEditProfile
        ) = createRefs()

        androidx.compose.material3.Text(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(titleEditProfile) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                },
            text = stringResource(id = R.string.title_profile_edit),
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
            color = Black
        )
        Image(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(imagePhone) {
                    top.linkTo(titleEditProfile.bottom, 16.dp)
                    start.linkTo(parent.start, 16.dp)
                },
            painter = painterResource(id = R.drawable.ic_phone),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        androidx.compose.material3.Text(
            modifier = Modifier
                .wrapContentSize()
                .constrainAs(valuePhone) {
                    top.linkTo(titleEditProfile.bottom, 16.dp)
                    start.linkTo(imagePhone.end, 8.dp)
                },
            text = stringResource(id = R.string.phone_sample),
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
            color = Black
        )

        Box(
            modifier = Modifier
                .size(68.dp, 68.dp)
                .background(
                    color = colorResource(id = R.color.red),
                    shape = CircleShape
                )
                .constrainAs(viewEditProfile) {
                    top.linkTo(parent.top, 16.dp)
                    end.linkTo(parent.end, 16.dp)
                },
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center),
            )
        }

        Spacer(modifier = Modifier
            .height(36.dp)
            .constrainAs(spacerEditProfile) {
                top.linkTo(imagePhone.bottom, 0.dp)
                start.linkTo(parent.start, 16.dp)
                end.linkTo(parent.end, 16.dp)
            })

    }
}