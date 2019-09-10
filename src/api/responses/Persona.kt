package com.frangovers.petsociety.API.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Persona(

    @Expose
    @SerializedName("Name")
    val name: String = "",

    @Expose
    @SerializedName("SuffersFrom")
    val suffers: String = ""

)