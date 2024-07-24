package shippingTracker.factory

import shippingTracker.shipment.*

class ShipmentFactory():Factory {

    override fun createShipment(input: List<String>): Shipment {
        //OK because we validated the creation input beforehand
        /*
        input[1] = shipment ID
        input[3] = shipmentType
        input[2] = CreationTimeStamp
        */
        val id = input[1]
        val creationTime = input[2]
        val type = input[3]
        return when(type){
            "bulk" -> BulkShipment(id,creationTime.toLong())
            "overnight" -> OvernightShipment(id,creationTime.toLong())
            "express" -> ExpressShipment(id,creationTime.toLong())
            else -> StandardShipment(id)
        }
    }
}