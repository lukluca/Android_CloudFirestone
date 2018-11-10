package cloudfirestone.infrastructure.navigation.listener

import cloudfirestone.infrastructure.navigation.DestinationInterface

interface NavigationListener {

    fun navigateTo(destination: DestinationInterface)

}

interface OnNavigateButtonClickListener {

    fun onNavigateClick(destination: DestinationInterface)

}