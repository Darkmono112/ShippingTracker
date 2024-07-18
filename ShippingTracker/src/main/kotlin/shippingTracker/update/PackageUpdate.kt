package shippingTracker.update

import shippingTracker.Shipment

abstract class PackageUpdate: Update{
    abstract val updateType: String
    abstract val shipment :Shipment
    abstract val timeStamp : Long
    init{
        this.updateShipment()
    }



}