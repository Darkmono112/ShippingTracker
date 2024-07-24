package shippingTracker

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import shippingTracker.update.*
import java.io.File

import shippingTracker.validation.UpdateValidator

class TrackingServer {

    private val updateValidator = UpdateValidator()
    private val tracker = Tracker()
    suspend fun startKtor(){
        embeddedServer(Netty,8080){
            routing {
                get("/") {
                    call.respondText(File("index.html").readText(), ContentType.Text.Html)
                }
                post("/data"){
                    //TODO send data updates this way
                    val data: List<String>? = updateValidator.validateInput(call.receiveText())
                    if(data != null){
                        createUpdate(data)
                        call.respondText { "Data sent to server" }
                    }
                    else{
                        call.respondText { "Invalid  Data Input" }
                    }

                }
            }
        }.start(wait = false )
    }


    private fun createUpdate(components : List<String>){
        //components[3] is other, since we don't know if other will be used we'll depend on the validator
        val type = components[0]
        val id = components[1]
        val timeArrived = components[2].toLong()
        // get the shipment, if it doesn't exist return null
        if("CREATED" == type.uppercase()){
            tracker.createShipment(components)
            return
        }
        //check if shipment actually exists then add the update
        val shipment = tracker.findShipment(id) ?: return
        if(components.size == 4){
            shipment.addUpdate(
                when(type){
                    "NOTE"-> Note(shipment,timeArrived,components[3])
                    "DELAYED" -> Delayed(shipment,timeArrived,components[3].toLong())
                    "SHIPPED" -> Shipped(shipment, timeArrived, components[3].toLong())
                    else -> Location(shipment,timeArrived,components[3])
                }
            )


        }
        
        shipment.addUpdate(
            when(type.uppercase()){
                "CANCELLED" -> Cancelled(shipment,timeArrived)
                "DELIVERED" -> Delivered(shipment,timeArrived)
                else -> Lost(shipment,timeArrived)
            }
        )

    }


}