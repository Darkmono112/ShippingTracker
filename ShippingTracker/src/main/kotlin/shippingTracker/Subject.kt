package shippingTracker

interface Subject {

    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
}