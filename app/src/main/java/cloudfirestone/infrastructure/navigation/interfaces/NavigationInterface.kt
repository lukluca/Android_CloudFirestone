package cloudfirestone.infrastructure.navigation.interfaces

import android.view.MenuItem

interface NavigationInterface {

    fun navigateTo(destination: DestinationInterface)

    fun handleTouch(item: MenuItem)
}