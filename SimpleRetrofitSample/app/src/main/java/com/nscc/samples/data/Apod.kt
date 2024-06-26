package com.nscc.samples.data

// from https://github.com/DhaneshShetty/NASAapod

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



//@Parcelize
data class Apod(@SerializedName("copyright")@Expose val copyright:String,
                @SerializedName("date") @Expose val date:String,
                @SerializedName("explanation") @Expose val explanation:String,
                @SerializedName("hdurl") @Expose val hdUrl:String,
                @SerializedName("media_type") @Expose val mediaType:String,
                @SerializedName("service_version") @Expose val version:String,
                @SerializedName("title") @Expose val title:String,
                @SerializedName("url") @Expose val url:String,
                @SerializedName("thumbnail_url") @Expose val thumbnailUrl:String
)
