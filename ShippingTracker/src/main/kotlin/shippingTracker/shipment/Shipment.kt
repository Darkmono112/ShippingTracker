package shippingTracker.shipment

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import shippingTracker.observer.Observer
import shippingTracker.update.Update

abstract class Shipment(val id:String): Subject {


    abstract var status :String
    val notes = mutableListOf<String>()

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

    abstract fun addUpdate(update:Update)

    fun notifySubscribers(){
        for( sub in subscribers){
            sub.update()
        }
    }

}