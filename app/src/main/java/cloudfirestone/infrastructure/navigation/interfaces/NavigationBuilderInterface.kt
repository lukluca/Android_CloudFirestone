package cloudfirestone.infrastructure.navigation.interfaces

import android.support.v4.app.FragmentManager
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.network.APIManagerInterface

interface NavigationBuilderInterface {
    fun build(): NavigationInterface
    fun containerViewId(containerViewId: Int): NavigationBuilderInterface
    fun apiManager(apiManager: APIManagerInterface): NavigationBuilderInterface
    fun fragmentManager(fragmentManager: FragmentManager): NavigationBuilderInterface
    fun navigationListener(navigationListener: NavigationListener): NavigationBuilderInterface
}