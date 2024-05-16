package fr.samneo.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.samneo.woof.ui.DogsListUi
import fr.samneo.woof.ui.theme.WoofTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Woof()
                }
            }
        }
    }
}

@Composable
fun Woof(modifier: Modifier = Modifier) {
    TopAppBar(modifier) {
        DogsListUi()
    }
}

@Preview(showBackground = true)
@Composable
fun WoofAppPreview() {
    WoofTheme {
        Woof()
    }
}