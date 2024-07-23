package shippingTracker.factory

import shippingTracker.shipment.*

class ShipmentFactory():Factory {
    override fun createShipment(id:String, type:String): Shipment {
        //OK because we validated the creation input beforehand
        return when(type){
            "bulk" -> BulkShipment(id)
            "overnight" -> OvernightShipment(id)
            "express" -> ExpressShipment(id)
            else -> StandardShipment(id)
        }
    }
}