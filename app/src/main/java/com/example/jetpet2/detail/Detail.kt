@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpet2.detail


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpet2.data.DummyPetDataSource

@Composable
fun DetailScreen(index: Int,onNavigate:() -> Unit) {
    Scaffold (
       topBar = {
           TopAppBar(
               title = {Text(text = "Detail")},
               navigationIcon = {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back to Page",
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                onNavigate.invoke()
                            },
                        tint = MaterialTheme.colorScheme.onSurface
                    )
               },


           )
       }
    ){
     PaddingValues ->
        val pet = DummyPetDataSource.dogList[index]
        LazyColumn(contentPadding = PaddingValues) {
            item {
                Image(
                    painter = painterResource(id = pet.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(346.dp),
                    alignment = Alignment.CenterStart,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreen(0){

    }
}