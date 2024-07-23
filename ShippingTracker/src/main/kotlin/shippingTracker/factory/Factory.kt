package shippingTracker.factory
import shippingTracker.shipment.Shipment
interface Factory {
    fun createShipment(id:String, type:String):Shipment
}