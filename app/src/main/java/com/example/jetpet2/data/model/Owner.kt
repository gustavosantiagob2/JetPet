package com.example.jetpet2.data.model

import androidx.annotation.DrawableRes

data class Owner(
    val name: String,
    val BasicInfo: String,
    @DrawableRes val image: Int
)
