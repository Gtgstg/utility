package com.hashedin.utility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button11.setOnClickListener({
            val intent=Intent(this,Dashboard::class.java)
            startActivity(intent)
        })
        button10.setOnClickListener({
            val intent=Intent(this,Welcome::class.java)
            startActivity(intent)
        })
    }
}
