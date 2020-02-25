package com.hashedin.utility.services
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*
interface OTP {
    @FormUrlEncoded
    @POST("/api/v1/generate-otp/")
    fun generate_OTP(@Field("type")type:String,@Field("username")username:String):Call<String>

    @FormUrlEncoded
    @POST("/api/v1/verify-otp/")
    fun verify_OTP(@Field("otp")otp:String,@Field("username")username:String):Call<JsonObject>
}