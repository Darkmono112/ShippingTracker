package shippingTracker.update

import shippingTracker.Shipment

class Note(
    override val shipment: Shipment,
    override val timeStamp: Long,
    private val note: String
): PackageUpdate(), Update {

    override val updateType: String = "Note"

    override fun updateShipment() {
        shipment.notes.add(note)
    }

}