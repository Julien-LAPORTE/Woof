package fr.samneo.woof.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.samneo.woof.R
import fr.samneo.woof.data.DataSource
import fr.samneo.woof.model.Dog
import fr.samneo.woof.ui.theme.WoofTheme
import fr.samneo.woof.viewmodel.DogsListUiViewModel

@Composable
fun DogsListUi(modifier: Modifier = Modifier, viewModel: DogsListUiViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(modifier) {
        items(DataSource.dogs) { dog ->
            DogCard(
                dog = dog,
                isExpanded = uiState.isExpanded[dog.index],
                onExpandedClick = { viewModel.updateIsExpanded(dog.index) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_small),
                        end = dimensionResource(id = R.dimen.padding_small),
                        bottom = dimensionResource(id = R.dimen.padding_medium)
                    ),
            )
        }
    }
}

@Composable
fun DogCard(
    dog: Dog, isExpanded: Boolean, onExpandedClick: () -> Unit, modifier: Modifier = Modifier
) {
    Card(modifier.animateContentSize(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = dog.picture),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_medium),
                        top = dimensionResource(id = R.dimen.padding_medium),
                        bottom = dimensionResource(id = R.dimen.padding_medium),
                        end = dimensionResource(id = R.dimen.padding_small)
                    )
                    .clip(MaterialTheme.shapes.small)
                    .size(dimensionResource(id = R.dimen.image_size)),
            )
            NameAndAgeColumn(name = stringResource(id = dog.name), age = dog.age)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = when (isExpanded) {
                    false -> Icons.Filled.ExpandMore
                    true -> Icons.Filled.ExpandLess
                },
                contentDescription = null,
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.padding_medium))
                    .align(Alignment.Bottom)
                    .clickable(enabled = true, onClick = onExpandedClick)
            )
        }
        if (isExpanded) {
            DescriptionColumn(
                description = stringResource(id = dog.description),
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
            )
        }
    }
}

@Composable
fun NameAndAgeColumn(name: String, age: Int) {
    Column {
        Text(text = name, style = MaterialTheme.typography.displayMedium)
        Text(
            text = stringResource(id = R.string.years_old, age),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun DescriptionColumn(description: String, modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.about), style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = description, style = MaterialTheme.typography.bodyLarge
        )
    }

}

@Preview
@Composable
fun DogsListUiPreview() {
    WoofTheme {
        DogsListUi()
    }
}

@Preview
@Composable
fun DogCardPreview() {
    WoofTheme {
        DogCard(DataSource.dogs[0], isExpanded = false, onExpandedClick = {})
    }
}

@Preview
@Composable
fun NameAndAgeColumnPreview() {
    WoofTheme {
        NameAndAgeColumn(
            name = stringResource(id = R.string.dog_name_1), age = 2
        )
    }
}