package com.deliveryhero.whetstone.viewmodel

import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.deliveryhero.whetstone.scope.ViewModelScope

/**
 * A generic [ViewModelFactoryProducer] which integrates with Dagger multi-binding and
 * handles Process Death out of the box.
 * Produces instances of [ViewModelProvider.Factory]. Typically implemented using
 * Dagger's Multi-Binding.
 *
 * The returned [ViewModelProvider.Factory] can retrieve any type of [ViewModel]
 * contributed to [ViewModelScope].
 */
@Deprecated("Legacy API. Please use the new injectedViewModel API instead")
public interface ViewModelFactoryProducer {

    /**
     * Provides a fully-constructed instance of [ViewModelProvider.Factory].
     */
    public fun createViewModelFactory(): ViewModelProvider.Factory
}

/**
 * Produces a fully-constructed instance of [ViewModelProvider.Factory].
 *
 * This is a convenience for explicitly passing a [ComponentActivity] as
 * a [SavedStateRegistryOwner] and properly getting the `defaultArgs` from
 * the [ComponentActivity.getIntent] extras.
 *
 * @see ViewModelFactoryProducer.createViewModelFactory
 */
@Deprecated("Legacy API", ReplaceWith("this.createViewModelFactory()"))
public fun ViewModelFactoryProducer.createViewModelFactory(
    activity: ComponentActivity
): ViewModelProvider.Factory = createViewModelFactory()

/**
 * Produces a fully-constructed instance of [ViewModelProvider.Factory].
 *
 * This is a convenience for explicitly passing a [Fragment] as
 * a [SavedStateRegistryOwner] and properly getting the `defaultArgs` from
 * the [Fragment.getArguments].
 *
 * @see ViewModelFactoryProducer.createViewModelFactory
 */
@Deprecated("Legacy API", ReplaceWith("this.createViewModelFactory()"))
public fun ViewModelFactoryProducer.createViewModelFactory(
    fragment: Fragment
): ViewModelProvider.Factory = createViewModelFactory()
