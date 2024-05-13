package com.example.jetpet2.data

import com.example.jetpet2.R
import com.example.jetpet2.data.model.Owner
import com.example.jetpet2.data.model.Pet

object DummyPetDataSource{
    private val owner = listOf(
        Owner(name = "Said","Developer", R.drawable.blue_dog),
        Owner(name = "Said","Engineer", R.drawable.blue_dog),
        Owner(name = "Said","Economist", R.drawable.blue_dog),
        Owner(name = "Said","Teacher", R.drawable.blue_dog),
        Owner(name = "Said","Scientist", R.drawable.blue_dog),
    )
    val dogList = listOf(
        Pet(
            id = 0,
            name = "Hachiko",
            age = "Adult",
            gender = "Male",
            color = "Brown",
            breed = "Chiuhauha",
            location = "Toronto CA",
            image = R.drawable.orange_dog,
            description = "Lorem ipsum dolor sit amet. Et distinctio fugit est corrupti laborum qui repellendus vitae ea alias omnis non consequatur quas. Et beatae laudantium id sapiente ullam",
            owner = owner[0]
        ),
        Pet(
            id = 1,
            name = "Skooby Doo",
            age = "Adult",
            gender = "Male",
            color = "Gold",
            breed = "Chiuhauha",
            location = "Toronto CA",
            image = R.drawable.blue_dog,
            description = "Lorem ipsum dolor sit amet. Et distinctio fugit est corrupti laborum qui repellendus vitae ea alias omnis non consequatur quas. Et beatae laudantium id sapiente ullam",
            owner = owner[1]
        ),
        Pet(
            id = 2,
            name = "Miss Agnes",
            age = "Adult",
            gender = "Female",
            color = "White",
            breed = "Chiuhauha",
            location = "Toronto CA",
            image = R.drawable.red_dog,
            description = "Lorem ipsum dolor sit amet. Et distinctio fugit est corrupti laborum qui repellendus vitae ea alias omnis non consequatur quas. Et beatae laudantium id sapiente ullam",
            owner = owner[2]
        ),
        Pet(
            id = 3,
            name = "Cyrus",
            age = "Baby",
            gender = "Male",
            color = "Black",
            breed = "Chiuhauha",
            location = "Toronto CA",
            image = R.drawable.yellow_dog,
            description = "Lorem ipsum dolor sit amet. Et distinctio fugit est corrupti laborum qui repellendus vitae ea alias omnis non consequatur quas. Et beatae laudantium id sapiente ullam",
            owner = owner[3]
        ),
        Pet(
            id = 4,
            name = "Shelby",
            age = "Baby",
            gender = "Female",
            color = "Choco",
            breed = "Chiuhauha",
            location = "Toronto CA",
            image = R.drawable.white_dog,
            description = "Lorem ipsum dolor sit amet. Et distinctio fugit est corrupti laborum qui repellendus vitae ea alias omnis non consequatur quas. Et beatae laudantium id sapiente ullam",
            owner = owner[4]
        )
    )


}