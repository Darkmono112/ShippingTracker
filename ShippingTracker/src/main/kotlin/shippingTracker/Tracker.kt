package shippingTracker

import shippingTracker.factory.ShipmentFactory
import shippingTracker.shipment.BulkShipment
import shippingTracker.shipment.Shipment
import shippingTracker.update.Created

class Tracker() {

    val shipments:MutableList<Shipment> = mutableListOf()
    private val shipmentFactory = ShipmentFactory()

    fun addShipment(shipment: Shipment){
        shipments.add(shipment)
    }

    fun findShipment(id:String):Shipment?{
        for(shipment in shipments){
            if(shipment.id == id){
                return shipment
            }
        }
        return null
    }

    fun createShipment(input: List<String>){
        /*
        input[1] = shipment ID
        input[3] = shipmentType
        input[2] = CreationTimeStamp
        */
        val shipment = shipmentFactory.createShipment(input[1],input[3])
        shipment.addUpdate(Created(shipment,input[2].toLong()))
        addShipment(shipment)

    }

}