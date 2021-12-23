package com.example.ministore.ui.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ministore.data.model.Page
import com.example.ministore.data.model.onboardPages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.example.ministore.R

@ExperimentalAnimationApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    onGettingStartedClick:()->Unit,
    onSkipClicked:()->Unit) {
    val pagerState = rememberPagerState(pageCount = 3)

    Column() {
         AnimatedVisibility(visible = pagerState.currentPage != 2 ) {
             Text(
                 text = "Skip",
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(6.dp)
                     .clickable { onSkipClicked() },
                 style = MaterialTheme.typography.h2,
                 fontSize = 26.sp,
                 fontWeight = FontWeight.W600
             )
        }


        HorizontalPager(state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) ) { page ->

            PageUI(page = onboardPages[page])
        }

        HorizontalPagerIndicator(pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = colorResource(R.color.primary_blue)
        )

        AnimatedVisibility(visible = pagerState.currentPage == 2 ) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp) ,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                onClick = onGettingStartedClick,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = colorResource(R.color.primary_blue),
                    contentColor = Color.White)) {
                Text(
                    text = "Get Started",
                    fontSize = 22.sp,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.W500
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Composable
fun PageUI(page: Page) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(page.image),
            contentDescription = null,
            modifier = Modifier.size(350.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = page.title,

            fontSize = 28.sp,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = page.description,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(8.dp),
            fontSize = 16.sp,
            style = MaterialTheme.typography.subtitle2,
        )
        Spacer(modifier = Modifier.height(12.dp))

    }
}