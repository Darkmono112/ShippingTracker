package shippingTracker.shipment

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.update.Update
import java.time.Instant
import java.time.temporal.ChronoUnit


class ExpressShipment(
    id:String,
    val creationDate:Long): Shipment(id) {

    override var status: String = "none"

    override fun addUpdate(update: Update) = runBlocking {
        if(update.updateType.uppercase() == "SHIPPED") checkExpress()
        if(!updateHistory.contains(update)){
            updateHistory.add(update)
        }
        launch{
            notifySubscribers()
        }
    }

    fun checkExpress(){
        val creation = Instant.ofEpochMilli(creationDate)
        val target = creation.plus(3, ChronoUnit.DAYS)
        val delivery = Instant.ofEpochMilli(expectedDeliveryTimestamp)

        if(delivery > target){
            this.status = "Shipment placed to deliver after 3 days"
        }

    }

}