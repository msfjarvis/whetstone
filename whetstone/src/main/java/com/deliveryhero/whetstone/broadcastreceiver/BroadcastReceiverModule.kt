package com.deliveryhero.whetstone.broadcastreceiver

import com.deliveryhero.whetstone.injector.MembersInjectorMap
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.multibindings.Multibinds

@Module
@ContributesTo(BroadcastReceiverScope::class)
public interface BroadcastReceiverModule {
    @Multibinds
    public fun membersInjectors(): MembersInjectorMap
}
