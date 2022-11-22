package com.example.comunicalibras

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.comunicalibras.data.Session

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPref: SharedPreferences
    lateinit var session: Session

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = getPreferences(Context.MODE_PRIVATE)
        session = Session(sharedPref)
    }

}