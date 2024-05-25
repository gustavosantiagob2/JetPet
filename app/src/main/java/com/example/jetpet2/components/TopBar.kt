package com.example.jetpet2.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpet2.R

@Composable
fun TopBar(onSwitchToggle: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = "Hey Gustavo",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier .height(8.dp))
            Text(
                text = "Find a new friend near you to adopt!",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    end = 36.dp
                )
        ){
            PetSwitch {
                onSwitchToggle.invoke()
            }

        }
    }
}

@Composable
fun PetSwitch(onSwitchToggle: () -> Unit) {
    val icon = if (isSystemInDarkTheme()){
        painterResource(id = R.drawable.ic_light)
    }else{
        painterResource(id = R.drawable.ic_dark
        )
    }

    Icon(
        painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(24.dp, 24.dp)
            .clickable(onClick = { onSwitchToggle.invoke() }),
        tint = MaterialTheme.colorScheme.onSurface
    )
}

@Preview(showSystemUi =  true)
@Composable
private fun TopBarPreview() {
    TopBar{

    }
}