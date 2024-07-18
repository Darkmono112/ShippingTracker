package shippingTracker.update

import shippingTracker.Shipment

class Location(
    override val shipment: Shipment,
    override val timeStamp: Long, val location:String
):PackageUpdate(),Update {
    override val updateType: String = "Location"

    override fun updateShipment() {
        shipment.currentLocation = location
    }
}