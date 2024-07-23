package shippingTracker.update

import shippingTracker.shipment.Shipment

class Shipped(
    override val shipment: Shipment,
    override val timeStamp: Long,
    val expectedDeliveryDate: Long
): PackageUpdate(), Update{
    override val updateType: String = "Shipped"

    override fun updateShipment() {
        shipment.status = "Shipped"
        shipment.expectedDeliveryTimestamp = expectedDeliveryDate
    }

}