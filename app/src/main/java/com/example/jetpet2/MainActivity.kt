package com.example.jetpet2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.jetpet2.data.DummyPetDataSource
import com.example.jetpet2.detail.DetailScreen
import com.example.jetpet2.detail.PetInfo
import com.example.jetpet2.home.Home
import com.example.jetpet2.ui.theme.JetPet2Theme


enum class Screen{
    Home,
    Detail
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember{
                mutableStateOf(false)
            }
            var currentScreen by remember {
                mutableStateOf(Screen.Home)
            }
            var selectedIndex by remember {
                mutableStateOf(-1)
            }

            JetPet2Theme(
                darkTheme = isDarkTheme
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) 
                {
                    DetailScreen(index = 0) {
                        
                    }
                    var pet = DummyPetDataSource.dogList[0]

                    PetInfo(pet = pet)
                    when(currentScreen){
                        Screen.Home -> {
                            Home(
                                onSwitchClick = { isDarkTheme =! isDarkTheme  },
                                onPetClick = { index ->
                                    currentScreen = Screen.Detail
                                    selectedIndex = index
                                }
                            )
                        }
                        Screen.Detail -> {
                            DetailScreen(index = selectedIndex) {
                                currentScreen = Screen.Home
                            }
                        }
                    }
                }
            }
        }
    }
}
