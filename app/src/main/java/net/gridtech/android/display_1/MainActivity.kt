package net.gridtech.android.display_1

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import net.gridtech.android.core.CoreService
import net.gridtech.android.core.CoreServiceBinder

class MainActivity : AppCompatActivity() {

    var binder: CoreServiceBinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindService(
            Intent(this, CoreService::class.java),
            object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    binder = service as CoreServiceBinder
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    binder = null
                }
            },
            Context.BIND_AUTO_CREATE
        )


        setContentView(R.layout.activity_main)
    }
}
