package cloudfirestone.infrastructure.navigation

import android.support.v4.app.FragmentManager
import cloudfirestone.infrastructure.injecter.Inj
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.network.APIManagerInterface

class NavigationManagerBuilder: NavigationBuilderInterface {

    private lateinit var apiManager: APIManagerInterface
    private lateinit var fragmentManager: FragmentManager
    private lateinit var navigationListener: NavigationListener

    override fun apiManager(apiManager: APIManagerInterface) = apply { this.apiManager = apiManager }

    override fun fragmentManager(fragmentManager: FragmentManager) = apply { this.fragmentManager = fragmentManager }

    override fun navigationListener(navigationListener: NavigationListener) = apply { this.navigationListener = navigationListener }

    override fun build(): NavigationInterface {
        return NavigationManager(fragmentManager, apiManager, navigationListener)
    }
}
