package com.nscc.samples.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Dog(@SerializedName("message")@Expose val url:String,
               @SerializedName("status")@Expose val status:String
)
