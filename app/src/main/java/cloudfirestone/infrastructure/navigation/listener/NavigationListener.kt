package cloudfirestone.infrastructure.navigation.listener

import cloudfirestone.infrastructure.navigation.Destination

interface NavigationListener {

    fun navigateTo(destination: Destination)

}

interface OnNavigateButtonClickListener {

    fun onNavigateClick(destination: Destination)

}