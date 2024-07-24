package shippingTracker.shipment

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.update.Update

class StandardShipment(id:String): Shipment(id) {
    //No need to change anything as this is the standard implementation from the abstract class
    override var status: String = "None"

    override fun addUpdate(update: Update){
        if(!updateHistory.contains(update)){
            updateHistory.add(update)
            update.updateShipment()
        }
        notifySubscribers()
    }

}