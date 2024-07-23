package shippingTracker.update

import shippingTracker.shipment.Shipment

class Delivered(override val shipment: Shipment, override val timeStamp: Long) :PackageUpdate(), Update{
    override val updateType: String = "Delivered"

    override fun updateShipment() {
        shipment.status = updateType
    }
}