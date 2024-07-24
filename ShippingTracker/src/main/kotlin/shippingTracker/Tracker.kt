package shippingTracker

import shippingTracker.factory.ShipmentFactory
import shippingTracker.shipment.Shipment
import shippingTracker.update.Created

class Tracker private constructor() {

    companion object {
        @Volatile
        private var instance: Tracker? = null
        fun getInstance() =
            instance ?: synchronized(this){
            instance ?: Tracker().also { instance = it }
        }
    }
    val shipments: MutableList<Shipment> = mutableListOf()
    private val shipmentFactory = ShipmentFactory()
    private fun addShipment(shipment: Shipment){
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

        val shipment = shipmentFactory.createShipment(input)
        shipment.addUpdate(Created(shipment,input[2].toLong()))
        addShipment(shipment)
        println(shipments)

    }

}