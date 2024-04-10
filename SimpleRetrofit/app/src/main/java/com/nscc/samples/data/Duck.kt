package com.nscc.samples.data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Duck(@SerializedName("message")@Expose val message:String,
                @SerializedName("url") @Expose val url:String
)
