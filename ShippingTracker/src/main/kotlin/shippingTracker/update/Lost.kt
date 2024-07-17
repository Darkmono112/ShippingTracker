package shippingTracker.update

import shippingTracker.Shipment

class Lost(shipment: Shipment, timeStamp: Long) : PackageUpdate() ,Update  {
    override val updateType = "Lost"
    override val shipment = shipment
    override val timeStamp = timeStamp


    override fun updateShipment(shipment: Shipment){
        shipment.st
    }



}