package cloudfirestone.infrastructure.navigation.classes

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import cloudfirestone.infrastructure.navigation.interfaces.DestinationInterface
import cloudfirestone.infrastructure.navigation.interfaces.NavigationInterface
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.sections.authentication.AuthenticationFragment
import cloudfirestone.sections.authentication.NewAccountFragment
import com.tagliabue.cloudfirestone.R

class NavigationManager(private val fragmentManager: FragmentManager,
                        private val navigationListener: NavigationListener,
                        private val containerViewId: Int) : NavigationInterface {

    override fun navigateTo(destination: DestinationInterface) {

        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment: Fragment? = when (destination) {

            Destination.AUTHENTICATION -> {
                val authenticationFragment = AuthenticationFragment()
                authenticationFragment.navigationListener = navigationListener

                authenticationFragment
            }

            Destination.NEW_ACCOUNT -> {
                val newAccountFragment = NewAccountFragment()

                newAccountFragment
            }

            else -> {
                null
            }
        }

        fragmentTransaction.add(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    override fun handleTouch(item: MenuItem) {

        when (item.itemId) {
            R.id.authentication -> {
                navigateTo(Destination.AUTHENTICATION)
            }
            R.id.nav_gallery -> {
                navigateTo(Destination.AUTHENTICATION)

            }
            R.id.nav_slideshow -> {
                navigateTo(Destination.AUTHENTICATION)

            }
            R.id.nav_manage -> {
                navigateTo(Destination.AUTHENTICATION)
            }
            R.id.nav_share -> {
                navigateTo(Destination.AUTHENTICATION)
            }
            R.id.nav_send -> {
                navigateTo(Destination.AUTHENTICATION)
            }
            else -> {
                navigateTo(Destination.AUTHENTICATION)
            }
        }
    }
}