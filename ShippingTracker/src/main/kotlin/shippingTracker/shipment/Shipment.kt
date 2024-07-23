package shippingTracker.shipment

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.observer.Observer
import shippingTracker.update.Update

abstract class Shipment(val id:String): Subject {


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

    //TODO error check this
    fun addUpdate(update:Update) = runBlocking{
        if(!updateHistory.contains(update)){
            updateHistory.add(update)

        }
        launch{
            notifySubscribers()
        }

    }
    private fun notifySubscribers(){
        for( sub in subscribers){
            sub.update()
        }
    }

}