package com.example.jetpet2.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpet2.components.PetInfoItem
import com.example.jetpet2.components.TopBar
import com.example.jetpet2.data.DummyPetDataSource


@Composable
fun Home(
    onSwitchClick: () -> Unit,
    onPetClick: (Int) -> Unit
){
    val petList = DummyPetDataSource.dogList
    Scaffold(
        topBar = {
             TopBar {
                 onSwitchClick()
            }
    }
    ) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            itemsIndexed(petList){
                    index,pet ->
                PetInfoItem(pet = pet) {
                    onPetClick(index)
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
        Home(onSwitchClick = {}) {
            
        }
}