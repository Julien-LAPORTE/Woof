package fr.samneo.woof.data

import fr.samneo.woof.R
import fr.samneo.woof.model.Dog

object DataSource {
    val dogs = listOf(
        Dog(
            index = 0,
            name = R.string.dog_name_1,
            description = R.string.dog_description_1,
            age = 2,
            picture = R.drawable.koda
        ),
        Dog(
            index = 1,
            name = R.string.dog_name_2,
            description = R.string.dog_description_2,
            age = 16,
            picture = R.drawable.lola
        ),
        Dog(
            index = 2,
            name = R.string.dog_name_3,
            description = R.string.dog_description_3,
            age = 2,
            picture = R.drawable.frankie
        ),
        Dog(
            index = 3,
            name = R.string.dog_name_4,
            description = R.string.dog_description_4,
            age = 8,
            picture = R.drawable.nox
        ),
        Dog(
            index = 4,
            name = R.string.dog_name_5,
            description = R.string.dog_description_5,
            age = 8,
            picture = R.drawable.faye
        ),
        Dog(
            index = 5,
            name = R.string.dog_name_6,
            description = R.string.dog_description_6,
            age = 14,
            picture = R.drawable.bella
        ),
        Dog(
            index = 6,
            name = R.string.dog_name_7,
            description = R.string.dog_description_7,
            age = 2,
            picture = R.drawable.moana
        ),
        Dog(
            index = 7,
            name = R.string.dog_name_8,
            description = R.string.dog_description_8,
            age = 7,
            picture = R.drawable.tzeitel
        ),
        Dog(
            index = 8,
            name = R.string.dog_name_9,
            description = R.string.dog_description_9,
            age = 4,
            picture = R.drawable.leroy
        ),
    )
}