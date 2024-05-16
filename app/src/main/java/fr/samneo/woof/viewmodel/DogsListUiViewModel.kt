package fr.samneo.woof.viewmodel

import fr.samneo.woof.model.DogsListUiState
import kotlinx.coroutines.flow.update


class DogsListUiViewModel : UiViewModel<DogsListUiState>(DogsListUiState()) {

    fun updateIsExpanded(index: Int) {
        _uiState.update { currentState ->
            val updatedIsExpanded = currentState.isExpanded.toMutableList()
            updatedIsExpanded[index] = !currentState.isExpanded[index]

            currentState.copy(isExpanded = updatedIsExpanded)
        }
    }
}