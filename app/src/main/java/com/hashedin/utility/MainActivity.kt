package com.hashedin.utility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.google.gson.JsonObject
import com.hashedin.utility.services.OTP
import com.hashedin.utility.services.serviceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var onetime: EditText
    lateinit var email: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username=findViewById(R.id.editText)
        email=findViewById(R.id.editText2)
        onetime=findViewById(R.id.editText3)
        button3.setOnClickListener{
            val name=editText.text.toString()
            val emailid=editText2.text.toString()
            val otp=onetime.text.toString()
            val apiService=serviceBuilder().getAPIInstance()
            val otpcall=apiService.verify_OTP(otp,emailid)
            val intent= Intent(this,SignUp::class.java)
            otpcall.enqueue(object:Callback<JsonObject>{
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    Log.i("Good", response.body().toString())
                    val abc=response.body()!!

                    startActivity(intent)
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Log.i("Good", t.toString())
                }
            })


        }
        button2.setOnClickListener{
            val name=editText.text
            val emailid=editText2.text.toString()

            val apiService=serviceBuilder().getAPIInstance()
            val otpcall=apiService.generate_OTP("phone",emailid)
            otpcall.enqueue(object:Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {

                }

                override fun onFailure(call: Call<String>, t: Throwable) {

                }
            })
        }
    }
}
