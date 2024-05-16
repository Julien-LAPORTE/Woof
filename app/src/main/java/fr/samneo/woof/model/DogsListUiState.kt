package fr.samneo.woof.model

import fr.samneo.woof.data.DataSource

data class DogsListUiState(
    val isExpanded: List<Boolean> = MutableList(DataSource.dogs.size) { false },
)