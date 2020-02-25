package com.hashedin.utility.services

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class serviceBuilder {
    private val URL="http://tradenapp-env.us-east-1.elasticbeanstalk.com/"
    private fun getRetroInstance():Retrofit{
        val gson=GsonBuilder().setLenient().create()
        return Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson)).build()
    }
    fun getAPIInstance():OTP
    {
        return  getRetroInstance().create(OTP::class.java)
    }
}