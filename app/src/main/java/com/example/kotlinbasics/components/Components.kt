package com.example.kotlinbasics.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//@Preview(showBackground = true)
@Composable
fun TextSimple() {
    YouTubThumb()
}

@Composable
fun YouTubThumb() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(50.dp),
                color = Color.White
            )
            Text(
                text = "▶",
                modifier = Modifier
                    .background(Color.Red)
                    .padding(20.dp),
                color = Color.White
            )
        }
    }
}

@Composable
fun UserName() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "zubair",
                modifier = Modifier
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color.Black
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(Color.Black)
            )
            Text(
                text = "zubair",
                modifier = Modifier
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
}

// sy start of compose
@Preview(showBackground = true)
@Composable
fun SimpleTestScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Header",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Content hear",
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Blue)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Button 1",
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .background(Color.Magenta)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Button 1",
                        color = Color.White
                    )
                }
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Button 2",
                        color = Color.White
                    )
                }
            }
        }
    }
}