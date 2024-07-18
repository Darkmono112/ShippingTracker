package shippingTracker

import shippingTracker.update.Update

class Shipment(val id:String):Subject {


    var status = "None"
    val notes = mutableListOf<String>()
    //TODO consider private
    var updateHistory = mutableListOf<Update>()
    var expectedDeliveryTimestamp: Long = 0
    var currentLocation = "unknown"
    private val subscribers = mutableListOf<Observer>()

    override fun subscribe(observer: Observer) {
        if(!subscribers.contains(observer)) subscribers.add(observer)

    }

    override fun unsubscribe(observer: Observer) {
        if(subscribers.contains(observer)) subscribers.remove(observer)
    }

    fun addUpdate(update:Update){
        if(!updateHistory.contains(update)) updateHistory.add(update)
        notifySubscribers()
    }

    //TODO Will probably have to make this async
    private fun notifySubscribers(){
        for( sub in subscribers){
            sub.update()
        }
    }

}