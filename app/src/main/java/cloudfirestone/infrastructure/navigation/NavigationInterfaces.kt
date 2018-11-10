package cloudfirestone.infrastructure.navigation

import android.support.v4.app.FragmentManager
import android.view.MenuItem
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.network.APIManagerInterface

interface NavigationInterface {

    fun navigateTo(destination: DestinationInterface)

    fun handleTouch(item: MenuItem)
}

interface NavigationBuilderInterface {

    fun build(): NavigationInterface

    fun fragmentManager(fragmentManager: FragmentManager): NavigationBuilderInterface

    fun apiManager(apiManager: APIManagerInterface): NavigationBuilderInterface

    fun navigationListener(navigationListener: NavigationListener): NavigationBuilderInterface

}