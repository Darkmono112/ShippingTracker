package shippingTracker.update

interface Update {
     val updateType: String
     fun updateShipment()
}