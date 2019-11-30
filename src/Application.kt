package com.frangovers.petsociety

import com.frangovers.petsociety.API.responses.Persona
import com.frangovers.petsociety.model.Article
import com.mongodb.MongoClientURI
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.http.ContentType
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import org.litote.kmongo.KMongo
import org.litote.kmongo.getCollection

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    val client =
        KMongo.createClient(MongoClientURI("mongodb://petsociety-api:yg3XbFhUShDrkE4Q@ds159747.mlab.com:59747/petsociety"))
    val database = client.getDatabase("petsociety")

    install(ContentNegotiation) {
        gson {
        }
    }

    routing {

        get("/") {
            call.respondText("Pet Society API", contentType = ContentType.Text.Plain)
        }

        get("/json/gson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/mrdka") {
            //Persona is data class with @Expose & @SerializedName("Name")
            call.respond(Persona("Kajul", "Alcoholism"))
        }

        get("/articles/all") {
            val col = database.getCollection<Article>()
            val list: List<Article> = col.find().toMutableList()
            call.respond(list)

        }
    }
}
