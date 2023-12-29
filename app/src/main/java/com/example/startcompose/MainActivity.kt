package com.example.startcompose

import android.content.res.Resources.Theme
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.startcompose.ui.theme.StartComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartComposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)

                ) {
                    CardTest()
                }
            }
        }
    }
}

@Composable
fun CardTest() {
    Card(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .height(250.dp), shape = RoundedCornerShape(
            topStart = 4.dp, topEnd = 4.dp
        ), border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
    ) {
        ShowProfileCard()
        DescriptionText()
    }
}

@Composable
fun ShowProfileCard() {
    val mapOfData = mapOf(
        "6,950" to "Posts", "436M" to "Followers", "76" to "Following"
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.fd),
            contentScale = ContentScale.FillHeight,
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(20.dp)
                .clip(CircleShape)
                .background(Color.White)
                .width(60.dp)
                .height(60.dp)
                .padding(10.dp),
        )
        mapOfData.forEach {
            Box(modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = it.key,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 26.sp
                    )
                    Text(
                        text = it.value, fontSize = 14.sp, fontWeight = FontWeight.W600
                    )
                }
            }
        }
    }
}


@Composable
@Preview
private fun PreviewDark() {
    StartComposeTheme(darkTheme = true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            CardTest()
        }
    }
}

@Composable
@Preview
private fun PreviewLight() {
    StartComposeTheme(darkTheme = false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)

        ) {
            CardTest()
        }
    }
}

@Composable
private fun DescriptionText() {

    Column(
        modifier = Modifier.padding(20.dp, 10.dp, 10.dp, 10.dp)
    ) {
        Text(
            text = "Instagram",
            style = TextStyle(
                fontFamily = FontFamily.Cursive, fontSize = 26.sp
            ),
            modifier = Modifier.padding(bottom = 4.dp) // Добавление отступа снизу для элемента Text
        )
        Text(
            text = "#YoursToMake",
            style = TextStyle(
                fontSize = 12.sp
            ),
            modifier = Modifier.padding(bottom = 4.dp) // Добавление отступа снизу для элемента Text
        )
        Text(
            text = "www.facebook.com/emotional",
            style = TextStyle(
                fontSize = 10.sp
            ),
            modifier = Modifier.padding(bottom = 4.dp) // Добавление отступа снизу для элемента Text
        )
        Button(shape = RoundedCornerShape(10), modifier = Modifier.padding(top = 4.dp), onClick = {

        }) {
            Text(text = "Follow")
        }
    }
}



