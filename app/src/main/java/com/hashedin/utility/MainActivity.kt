package com.hashedin.utility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hashedin.utility.services.OTP
import com.hashedin.utility.services.serviceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button3.setOnClickListener{
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)

        }
        button2.setOnClickListener{
//            val OTP =serviceBuilder.buildService(OTP::class.java)
//            val requestCall=OTP.generate_OTP()
//            requestCall.enqueue(object: Callback<OTP>{
//
//                override fun onResponse(call: Call<OTP>, response: Response<OTP>) {
//                    if(response.isSuccessful) {
//                        val otp = response.body()!!
//                    }
//                }
//
//                override fun onFailure(call: Call<OTP>, t: Throwable) {
//                }
//            })
            val apiService=serviceBuilder().getAPIInstance()
            val otpcall=apiService.generate_OTP("phone","+91 9953226546")
            otpcall.enqueue(object:Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    val abc=response.body()!!
//                    print(abc)
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }
    }
}
