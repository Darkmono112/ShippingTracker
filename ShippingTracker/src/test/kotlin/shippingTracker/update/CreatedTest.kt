package shippingTracker.update

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import shippingTracker.shipment.StandardShipment

class CreatedTest {



    @Test
    fun getUpdateType() {
        kotlin.test.assertEquals("Created",shipment.updateHistory[0].updateType)
    }

    @Test
    fun updateShipment() {

        kotlin.test.assertEquals("Created",shipment.status)
    }

    @Test
    fun getShipment() {
    }

    @Test
    fun getTimeStamp() {
    }

    companion object {
        val shipment = StandardShipment("s13001")
        @JvmStatic
        @BeforeAll
        fun setShipment(): Unit {
            shipment.addUpdate(Created(shipment, 123456798))
        }
    }
}