package shippingTracker.update

import shippingTracker.Shipment

abstract class PackageUpdate{
//    +updateType:String
//    +shipment:Shipment
//    +timeRecieved:Long

    abstract val updateType: String
    abstract val shipment :Shipment
    abstract val timeStamp : Long

}