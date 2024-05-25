@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpet2.detail


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import com.example.jetpet2.components.OwnerCardInfo
import com.example.jetpet2.components.PetBasicInfoItem
import com.example.jetpet2.data.DummyPetDataSource
import com.example.jetpet2.data.model.Pet

@Composable
fun DetailScreen(index: Int, onNavigate: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
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
    ) { PaddingValues ->
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
                Spacer(modifier = Modifier.height(16.dp))
                PetBasicInfoItem(name = pet.name, gender = pet.gender, location = pet.location)
            }
            item {
                MyStoryItem(pet = pet)
            }
            item {
                PetInfo(pet = pet)
            }

            item{
                OwnerCardInfo(owner = pet.owner)
            }

            item {
                PetButton {

                }
            }
        }
    }
}

@Composable
fun PetButton(onClick:() -> Unit) {
    Spacer(modifier = Modifier .height(36.dp))
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Adopt Me"
        )
    }
    Spacer(modifier = Modifier .height(24.dp))
}

@Composable
fun PetInfo(pet: Pet) {
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        Title(title = "Pet Info")
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            InfoCard(
                primaryText = pet.age, secondaryText = "Age", modifier = Modifier
                    .weight(1F)
                    .padding(4.dp)
            )
            InfoCard(
                primaryText = pet.color, secondaryText = "Color", modifier = Modifier
                    .weight(1F)
                    .padding(4.dp)
            )
            InfoCard(
                primaryText = pet.breed, secondaryText = "Breed", modifier = Modifier
                    .weight(1F)
                    .padding(4.dp)
            )
        }
    }
}

@Composable
fun InfoCard(
    modifier: Modifier = Modifier,
    primaryText: String,
    secondaryText: String,
) {
    Surface(
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CompositionLocalProvider(
                LocalContentAlpha provides ContentAlpha.disabled
            ) {
                Text(text = secondaryText)
            }
            Text(
                text = primaryText,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}

@Composable
fun MyStoryItem(pet: Pet) {
    Column {
        Spacer(modifier = Modifier.height(24.dp))
        Title(title = "My Story")
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = pet.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        color = MaterialTheme.colorScheme.onSurface,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.W600,
        textAlign = TextAlign.Start
    )
}

@Preview(showSystemUi = true)
@Composable
private fun DetailScreenPreview() {
    DetailScreen(0) {

    }
}

@Preview(showBackground = true)
@Composable
private fun InforCardPreview() {
    val pet = DummyPetDataSource.dogList[0]
    PetInfo(pet = pet)
}