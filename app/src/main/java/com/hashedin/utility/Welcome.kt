package com.hashedin.utility

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {
    lateinit var viewPager:ViewPager
    lateinit var adapter: CustomSwipeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        viewPager=findViewById(R.id.view_pager)
        adapter= CustomSwipeAdapter(this)
        viewPager.setAdapter(adapter)
        button7.setOnClickListener({
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        })
        button8.setOnClickListener({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
        button9.setOnClickListener({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        })
    }
}
