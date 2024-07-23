package shippingTracker.update

import shippingTracker.shipment.Shipment

class Lost(
    override val shipment: Shipment,
    override val timeStamp: Long
) : PackageUpdate(), Update {
    override val updateType = "Lost"

    override fun updateShipment(){
        shipment.status = updateType
    }



}