package cloudfirestone.infrastructure.navigation.listener

import cloudfirestone.infrastructure.navigation.DestinationFragment

interface NavigationListener {

    fun navigateTo(destinationFragment: DestinationFragment)

}

interface OnNavigateButtonClickListener {

    fun onNavigateClick(destinationFragment: DestinationFragment)

}