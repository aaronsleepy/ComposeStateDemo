package song.aaron.composestatedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import song.aaron.composestatedemo.ui.theme.ComposeStateDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStateDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {
    MyTextField()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var textState by remember { mutableStateOf("") }

    val onTextChange = { text: String ->
        textState = text
    }

    TextField(
        value = textState,
        onValueChange = onTextChange
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeStateDemoTheme {
        DemoScreen()
    }
}
