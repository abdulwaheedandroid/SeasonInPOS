package com.abdulwaheed.seasoninnpos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.abdulwaheed.seasoninnpos.components.MainScreen
import com.abdulwaheed.seasoninnpos.ui.theme.SeasonInnPOSTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SeasonInnPOSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(innerPadding)
                }
            }
        }
    }
}

/*

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SeasonInnPOSTheme {
        MainScreen()
    }
}*/
