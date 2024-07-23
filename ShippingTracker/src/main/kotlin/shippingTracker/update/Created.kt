package shippingTracker.update

import shippingTracker.shipment.Shipment

class Created(
    override val shipment: Shipment,
    override val timeStamp: Long
):PackageUpdate() {
    override val updateType = "Created"
    override fun updateShipment() {
        shipment.status = updateType
    }
}