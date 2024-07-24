package shippingTracker.shipment

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.update.Update
import java.time.Instant
import java.time.temporal.ChronoUnit;


class BulkShipment(
    id:String,
    private val creationTime:Long
):Shipment(id) {

    override var status: String = "None"

    override fun addUpdate(update:Update) = runBlocking{
        if(update.updateType.uppercase() == "SHIPPED") checkBulk()
        if(!updateHistory.contains(update)){
            updateHistory.add(update)
        }
        launch{
            notifySubscribers()
        }

    }
    private fun checkBulk(){
        val creation = Instant.ofEpochMilli(creationTime)
        val target = creation.plus(3, ChronoUnit.DAYS)
        val delivery = Instant.ofEpochMilli(expectedDeliveryTimestamp)

        if(delivery < target){
            this.status = "Shipment placed to deliver before 3 days"
        }



    }

}