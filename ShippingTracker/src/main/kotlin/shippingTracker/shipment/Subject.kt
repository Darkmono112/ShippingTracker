package shippingTracker.shipment

import shippingTracker.observer.Observer

interface Subject {

    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
}