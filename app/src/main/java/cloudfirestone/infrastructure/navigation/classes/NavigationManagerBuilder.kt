package cloudfirestone.infrastructure.navigation.classes

import android.support.v4.app.FragmentManager
import cloudfirestone.infrastructure.navigation.interfaces.NavigationBuilderInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationInterface
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.network.APIManagerInterface
import cloudfirestone.sections.injector

class NavigationManagerBuilder: NavigationBuilderInterface {

    private var containerViewId: Int = 0
    private lateinit var apiManager: APIManagerInterface
    private lateinit var fragmentManager: FragmentManager
    private lateinit var navigationListener: NavigationListener

    override fun containerViewId(containerViewId: Int) = apply { this.containerViewId = containerViewId }

    override fun apiManager(apiManager: APIManagerInterface) = apply { this.apiManager = apiManager }

    override fun fragmentManager(fragmentManager: FragmentManager) = apply { this.fragmentManager = fragmentManager }

    override fun navigationListener(navigationListener: NavigationListener) = apply { this.navigationListener = navigationListener }

    override fun build(): NavigationInterface {
        //TODO find a way to warn at compile time with reflection
        return injector.navigationManagerConstructor.call(fragmentManager, apiManager, navigationListener, containerViewId)
    }
}
