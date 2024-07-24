package shippingTracker.observer


import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import java.time.Instant
import shippingTracker.Tracker
import shippingTracker.shipment.Shipment
import shippingTracker.shipment.StandardShipment

class TrackerViewHelper(shipmentId:String): Observer {


    val tracker = Tracker.getInstance()

    val shipment:Shipment = if(tracker.findShipment(shipmentId) != null) tracker.findShipment(shipmentId).also {
        if (it != null) {
            it.subscribe(this)
        }
    }!! else{
        val temp = StandardShipment(shipmentId)
        temp.status = "Tracking Invalid Package"
        temp
    }

    val shipmentId by mutableStateOf( shipment.id)
    var shipmentUpdateHistory by mutableStateOf( shipment.updateHistory)
    var expectedShipmentDeliveryDate by mutableStateOf(shipment.expectedDeliveryTimestamp)
    var shipmentStatus by mutableStateOf(shipment.status)
    var shipmentLocation by mutableStateOf(shipment.currentLocation)
    var shipmentNotes by mutableStateOf(shipment.notes)

    fun convertLongToDateTime(timeStamp: Long) : String{
        val date = Instant.ofEpochMilli(timeStamp)
        return date.toString()
    }

    override fun update() {
        shipmentUpdateHistory = shipment.updateHistory
        expectedShipmentDeliveryDate = shipment.expectedDeliveryTimestamp
        shipmentStatus = shipment.status
    }

}