package shippingTracker.factory
import shippingTracker.shipment.Shipment
interface Factory {
    fun createShipment(input:List<String>):Shipment
}