package com.deliveryhero.whetstone.broadcastreceiver

import com.deliveryhero.whetstone.InternalWhetstoneApi
import com.deliveryhero.whetstone.meta.AutoInjectorBinding

@OptIn(InternalWhetstoneApi::class)
@AutoInjectorBinding(scope = BroadcastReceiverScope::class)
public annotation class ContributesBroadcastReceiverInjector
