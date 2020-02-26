package com.hashedin.utility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

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
    }
}
