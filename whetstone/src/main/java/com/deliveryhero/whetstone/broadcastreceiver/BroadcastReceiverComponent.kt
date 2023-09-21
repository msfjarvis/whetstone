package com.deliveryhero.whetstone.broadcastreceiver

import android.content.BroadcastReceiver
import com.deliveryhero.whetstone.app.ApplicationScope
import com.deliveryhero.whetstone.injector.MembersInjectorMap
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.optional.SingleIn
import dagger.BindsInstance

@ContributesSubcomponent(scope = BroadcastReceiverScope::class, parentScope = ApplicationScope::class)
@SingleIn(BroadcastReceiverScope::class)
public interface BroadcastReceiverComponent {
    public val membersInjectorMap: MembersInjectorMap

    @ContributesSubcomponent.Factory
    public interface Factory {
        public fun create(@BindsInstance receiver: BroadcastReceiver): BroadcastReceiverComponent
    }

    @ContributesTo(ApplicationScope::class)
    public interface ParentComponent {
        public fun getBroadcastReceiverFactory(): Factory
    }
}
