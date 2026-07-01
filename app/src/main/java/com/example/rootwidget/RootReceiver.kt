package com.example.rootwidget

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.io.DataOutputStream

class RootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {

        if (intent?.action == "RUN_ROOT") {

            try {
                val process = Runtime.getRuntime().exec("su")
                val os = DataOutputStream(process.outputStream)

                os.writeBytes("killall audioserver\n")
                os.writeBytes("exit\n")
                os.flush()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
