/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.main_weather_animated_view

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.main_view.MainViewBackgroundView
import com.example.androiddevchallenge.theme.MainTheme

@Composable
fun MainWeatherAnimatedView(
    modifier: Modifier = Modifier,
    preview: Boolean = false
) {
    Box(
        modifier = modifier
            .width(230.dp)
            .height(230.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.main_weather_animated_view_circle_with_shadow),
            contentDescription = "Weather",
            colorFilter = ColorFilter.tint(Color(0xFFFFEB3B)),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .zIndex(0f)
                .scale(2.8f)
                .padding(
                    start = 0.dp,
                    top = 0.dp,
                    end = 0.dp,
                    bottom = 0.dp
                )
                .align(Alignment.Center)
        )
        Image(
            painter = painterResource(R.drawable.main_weather_animated_view_circle_gradient_yellow),
            contentDescription = "Weather",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .zIndex(1f)
                .align(Alignment.Center)
        )
        // https://medium.com/nerd-for-tech/jetpack-compose-pulsating-effect-4b9f2928d31a
        val figureScale by rememberInfiniteTransition().animateFloat(
            initialValue = 1.44f,
            targetValue = 1.56f,
            animationSpec = infiniteRepeatable(
                animation = tween(1200),
                repeatMode = RepeatMode.Reverse
            )
        )
        Image(
            painter = painterResource(R.drawable.main_weather_animated_view_figure_1),
            contentDescription = "Weather figure",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .scale(figureScale)
                .zIndex(2f)
                .align(Alignment.Center)
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun MainWeatherAnimatedViewLightPreview() {
    MainTheme {
        Surface {
            MainViewBackgroundView {
                MainWeatherAnimatedView(
                    preview = true,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun MainWeatherAnimatedViewDarkPreview() {
    MainTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            MainViewBackgroundView {
                MainWeatherAnimatedView(
                    preview = true,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}
