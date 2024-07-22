 import shippingTracker.TrackingServer
 import androidx.compose.desktop.ui.tooling.preview.Preview
 import androidx.compose.foundation.layout.Column
 import androidx.compose.foundation.layout.Row
 import androidx.compose.foundation.layout.padding
 import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
 import androidx.compose.material.TextField
 import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
 import kotlinx.coroutines.launch
 import kotlinx.coroutines.runBlocking

 @Composable
@Preview
fun App() {

    //Create and us the TrackerViewHelper



    MaterialTheme {
        Column{
            Row {
                var text by remember { mutableStateOf("") }
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Tracking Number") },
                    modifier = Modifier.padding(),
                    placeholder = { Text("Enter Tracking ID") }
                )
                Button(onClick = {
                    //Reset tracking box
                    text = ""
                }) {
                    Text("Track")
                }
            }
        }

    }
}

fun main() = application {
    startServer()

    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

 fun startServer() = runBlocking {
      launch{
         val ktorStuf = TrackingServer()
         ktorStuf.startKtor()
     }
 }