package shippingTracker.update
import shippingTracker.Shipment

interface Update {
     fun updateShipment(shipment: Shipment){}
}