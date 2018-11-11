package cloudfirestone.infrastructure.navigation.interfaces

import android.support.v4.app.FragmentManager
import cloudfirestone.infrastructure.navigation.listener.NavigationListener

interface NavigationBuilderInterface {
    fun build(): NavigationInterface
    fun containerViewId(containerViewId: Int): NavigationBuilderInterface
    fun fragmentManager(fragmentManager: FragmentManager): NavigationBuilderInterface
    fun navigationListener(navigationListener: NavigationListener): NavigationBuilderInterface
}