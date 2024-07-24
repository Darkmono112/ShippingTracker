import shippingTracker.TrackingServer
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.observer.TrackerViewHelper

@Composable
@Preview
fun App() {

    var viewHelperList = remember { mutableListOf<TrackerViewHelper>()}

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
                    viewHelperList.add(TrackerViewHelper(text))
                    text = ""
                }) {
                    Text("Track")
                }
            }
            for(helper in viewHelperList){
                Row{
                    Column {
                        Text("Shipment ID: ${helper.shipmentId}")
                        Text("Status: ${helper.shipmentStatus}")
                        Text("Location:${helper.shipmentLocation}")
                        Text("Est delivery date${helper.convertLongToDateTime(helper.expectedShipmentDeliveryDate)}" )
                        Text("Status Updates:")
                        for(status in helper.shipmentUpdateHistory)
                        {
                            Text(status.updateType)
                        }
                        Text("Notes:")
                        for(note in helper.shipmentNotes){
                            Text(note)
                        }
                    }
                    Button(
                        onClick = {

                        }
                    ){
                        Text("StopTracking")
                    }
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