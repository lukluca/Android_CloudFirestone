package cloudfirestone.infrastructure.navigation.listener

import cloudfirestone.infrastructure.navigation.interfaces.DestinationInterface

interface NavigationListener {

    fun navigateTo(destination: DestinationInterface)

}

interface OnNavigateButtonClickListener {

    fun onNavigateClick(destination: DestinationInterface)

}