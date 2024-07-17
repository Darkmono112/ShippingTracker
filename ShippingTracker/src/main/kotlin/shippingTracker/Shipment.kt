package shippingTracker

import shippingTracker.update.Update

class Shipment(val id:String):Subject {




//    +subscribers: List<Observers>
    var status = "None"
    val notes = mutableListOf<String>()
    var updateHistory = mutableListOf<Update>()
    var expectedDeliveryTimestamp: Long = 0
    var currentLocation = "unknown"

    val subscribers = mutableListOf<Observer>()





    override fun subscribe() {
        TODO("Not yet implemented")
    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }

    fun addUpdate(update:Update){
        //Add the update
        notifySubscribers()
    }

    private fun notifySubscribers(){

    }

}