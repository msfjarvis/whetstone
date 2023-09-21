package com.deliveryhero.whetstone.sample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.deliveryhero.whetstone.Whetstone
import com.deliveryhero.whetstone.broadcastreceiver.ContributesBroadcastReceiverInjector
import javax.inject.Inject

@ContributesBroadcastReceiverInjector
class MainBroadcastReceiver : BroadcastReceiver() {

    @Inject
    internal lateinit var dependency: MainDependency

    override fun onReceive(context: Context, p1: Intent) {
        Whetstone.inject(this, context)
        Log.d("BroadcastReceiver", dependency.getMessage("Broadcast Receiver"))
    }
}
