package shippingTracker.shipment

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.update.Update
import java.time.Instant
import java.time.temporal.ChronoUnit

class OvernightShipment(
    id:String,
    private val creationTime: Long
): Shipment(id) {
    override var status: String = "none"

    override fun addUpdate(update: Update){
        if(update.updateType.uppercase() == "SHIPPED") checkOvernight()
        if(!updateHistory.contains(update)){
            updateHistory.add(update)
            update.updateShipment()
        }

            notifySubscribers()


    }

    private fun checkOvernight() {
        val creation = Instant.ofEpochMilli(creationTime)
        val target = creation.plus(1, ChronoUnit.DAYS)
        val delivery = Instant.ofEpochMilli(expectedDeliveryTimestamp)

        if(delivery > target){
            this.status = "Shipment placed to deliver later than expected"
        }
    }
}
