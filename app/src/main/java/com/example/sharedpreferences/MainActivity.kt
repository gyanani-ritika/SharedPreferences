package com.example.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    companion object{ var MESSAGES_ID = "Messages_prefs"}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtView : TextView = findViewById(R.id.textView)
        val edtText : EditText = findViewById(R.id.edtText)
        val button :Button = findViewById(R.id.button)
        button.setOnClickListener{
            val string : String = edtText.text.toString()
            val sharedPreferences : SharedPreferences = getSharedPreferences(MESSAGES_ID,
                MODE_PRIVATE )
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("Message",string)
            editor.apply() //saving the message
            Toast.makeText(this@MainActivity, "Please Reopen your app to see changes", Toast.LENGTH_LONG).show()

        }
        //getting data back
        val getData : SharedPreferences = getSharedPreferences(MESSAGES_ID,MODE_PRIVATE)
         val value : String? = getData.getString("Message","Nothing Yet!")
        txtView.text = "$value"

    }
}