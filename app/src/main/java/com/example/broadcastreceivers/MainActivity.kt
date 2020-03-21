package com.example.broadcastreceivers

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initiate connection
        val c = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        //check for active network, wifi, mobile
        val networkInfo = c.activeNetworkInfo

        if (networkInfo != null  && networkInfo.isConnected) {

            //check if the network is connected throuh a mobile or wifi

            if (networkInfo.type == ConnectivityManager.TYPE_MOBILE) {

                Toast.makeText(applicationContext, "Connected to mobile", Toast.LENGTH_LONG).show()

            }


            if (networkInfo.type == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(applicationContext, "Connected to wi-fi", Toast.LENGTH_LONG).show()
            }

        }  else {
            //if its null and not connected
            //Toast.makeText(applicationContext, "You are offline", Toast.LENGTH_LONG).show()

            //making the message display at the center
            val toast =  Toast.makeText(applicationContext, "You are offline", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0,0)
            toast.show()

        }



    }
}
