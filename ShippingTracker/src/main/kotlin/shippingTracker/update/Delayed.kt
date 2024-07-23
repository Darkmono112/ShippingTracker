package shippingTracker.update

import shippingTracker.shipment.Shipment
//TODO check for privateability
class Delayed(
    override val shipment: Shipment,
    override val timeStamp: Long,
    val newExpectedDeliveryDate: Long
) : PackageUpdate(), Update {
    override val updateType: String = "Delayed"

    override fun updateShipment() {
        shipment.status = updateType
        shipment.expectedDeliveryTimestamp = newExpectedDeliveryDate
    }
}