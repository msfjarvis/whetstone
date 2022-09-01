package com.deliveryhero.whetstone.component

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.deliveryhero.whetstone.SingleIn
import com.deliveryhero.whetstone.injector.MembersInjectorMap
import com.deliveryhero.whetstone.scope.ApplicationScope
import com.squareup.anvil.annotations.ContributesTo
import dagger.BindsInstance
import javax.inject.Singleton

/**
 * A Dagger component that has the lifetime of the [android.app.Application].
 */
@ContributesTo(ApplicationScope::class)
@SingleIn(ApplicationScope::class)
@Singleton
public interface ApplicationComponent {
    public fun getViewModelFactory(): ViewModelProvider.Factory
    public fun getMembersInjectorMap(): MembersInjectorMap

    /**
     * Interface for creating an [ApplicationComponent].
     */
    public interface Factory {
        public fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
