package kuku.chickenmanagement.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kuku.chickenmanagement.MainActivity
import kuku.chickenmanagement.R

class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

    }

//    override fun onBackPressed() {
//        startActivity(Intent(this, MainActivity::class.java))
//        finish()
//        super.onBackPressed()
//    }
}
