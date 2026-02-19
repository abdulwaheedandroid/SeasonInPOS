package com.abdulwaheed.seasoninnpos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.abdulwaheed.seasoninnpos.components.MainScreen
import com.abdulwaheed.seasoninnpos.ui.theme.SeasonInnPOSTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeasonInnPOSTheme {
                MainScreen()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SeasonInnPOSTheme {
        MainScreen()
    }
}
