package shippingTracker.update

import shippingTracker.shipment.Shipment

class Cancelled(
    override val shipment: Shipment,
    override val timeStamp: Long
):PackageUpdate(),Update {
    override val updateType: String = "Cancelled"

    override fun updateShipment() {
        shipment.status = updateType
        shipment.expectedDeliveryTimestamp = 0
    }
}