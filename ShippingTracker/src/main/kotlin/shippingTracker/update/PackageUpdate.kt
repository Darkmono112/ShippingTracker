package shippingTracker.update

import shippingTracker.shipment.Shipment

abstract class PackageUpdate: Update{
    abstract val shipment : Shipment
    abstract val timeStamp : Long


}