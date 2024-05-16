package fr.samneo.woof.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Dog(
    val index: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    val age: Int,
    @DrawableRes val picture: Int,
) {
    init {
        require(age >= 0) { "L'âge ne peut pas être négatif" }
    }
}
