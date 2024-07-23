package shippingTracker.observer

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.util.*


class TrackerViewHelper(shipmentId: String): Observer {


//    +shipmentTotes: State<String[]>
//    +shipmentUpdateHistory: State<String[]>
//    +expectedShipmentDeliveryDate: State<String>
//    + shipmentStatus: State<String>

var shipmentId: State<String> =  mutableStateOf(shipmentId)
//var shipmentUpdatehHistory by remember { mutableStateOf(mutableListOf(String)) }




    private fun convertLongToDateTime(timeStamp: Long) : String{
        val date = Date(timeStamp)
        return date.toString()
    }

    override fun update() {

    }

}