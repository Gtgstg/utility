package com.hashedin.utility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.gson.JsonObject
import com.hashedin.utility.services.serviceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.button22
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUp : AppCompatActivity() {
    lateinit var username: EditText
    lateinit var email: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
//        username=findViewById(R.id.editText19)
//        email=findViewById(R.id.editText13)
//        val name=intent.getStringExtra("Name")
//        val emailid=intent.getStringExtra("Email")
//        username.setText(name)
//        email.setText(emailid)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        button14.setOnClickListener{
            val intent= Intent(this,Dashboard::class.java)
            startActivity(intent)
        }
        button22.setOnClickListener {
            val name=editText.text.toString()
            val emailid=editText2.text.toString()
            val verifiedToken=""
            val password=""
            val apiService= serviceBuilder().getAPIInstance()
            val otpcall=apiService.signUp(emailid,name,password,true,verifiedToken)
            val intent= Intent(this,SignUp::class.java)
//            intent.putExtra("Name",name)
//            intent.putExtra("Email",emailid)
            otpcall.enqueue(object: Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                    Log.i("Good", response.toString())
//                    val body=response.toString()
//                    Log.i("Hi",body)
//                    val gson=GsonBuilder().create()
//                    val data=gson.fromJson(response.body(),Data::class.java).verified_user
//                    intent.putExtra("Token",data)
//                    Log.i("Hi",data.toString())
//                    Log.i("P",data.message)
                    startActivity(intent)
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    startActivity(intent)
                }
            })
        }
    }
}
