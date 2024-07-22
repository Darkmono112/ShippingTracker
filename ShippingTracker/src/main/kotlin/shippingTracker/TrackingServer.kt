package shippingTracker

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File


//singleton

public class TrackingServer() {

    suspend fun startKtor(){
        embeddedServer(Netty,8080){
            routing {
                get("/") {
                    call.respondText(File("index.html").readText(), ContentType.Text.Html)
                }
            }
        }.start(wait = false )
    }
}