package com.example.jetpackui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackui.ui.theme.JetPackUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserCard()
        }
    }
}

@Composable
fun UserCard (){
    val context = LocalContext.current
    Column(
        Modifier.padding(16.dp).background(color = colorResource(id = R.color.white)),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "JetPack Compose UI",
            fontFamily = FontFamily.Cursive,
            fontSize = 32.sp,
            color = colorResource(id = R.color.black),
            modifier = Modifier
                .clickable {
                    Toast
                        .makeText(context, "Text Clicked", Toast.LENGTH_SHORT)
                        .show()
                }
                .align(
                    alignment = Alignment.CenterHorizontally
                )
        )
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(id = R.string.dummyText),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.clickable {
                        Toast.makeText(context, "Text Clicked", Toast.LENGTH_SHORT).show()
                    })
                 Button(onClick = {
                     Toast.makeText(context, "Text Clicked", Toast.LENGTH_SHORT).show()
                 }) {
                     Text(text = "ClickMe")

                 }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview(){
    androidx.compose.material.Surface (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            ){
        UserCard()
    }
}