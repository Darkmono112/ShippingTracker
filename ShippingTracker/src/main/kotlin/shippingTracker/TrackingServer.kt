package shippingTracker

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

import shippingTracker.validation.UpdateValidator

public class TrackingServer() {

    private val updateValidator = UpdateValidator()

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
                    }
                    println(data)
                    call.respondText { "Data sent to server" }
                }
            }
        }.start(wait = false )
    }


    private fun createUpdate(components : List<String>){
        when (components[0]){

        }

    }


}