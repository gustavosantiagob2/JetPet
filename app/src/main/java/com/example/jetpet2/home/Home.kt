package com.example.jetpet2.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpet2.components.PetInfoItem
import com.example.jetpet2.components.TopBar
import com.example.jetpet2.data.DummyPetDataSource

@Composable
fun Home(
    
) {
    val petList = DummyPetDataSource.dogList

    Scaffold(
        topBar = {
            TopBar {

            }
        }
    ) {
            PaddingValues ->
        LazyColumn(
            contentPadding = PaddingValues
        ) {
            items(petList){pet ->
                PetInfoItem(pet = pet ) {
                }
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun HomePreview() {
    Home()
}