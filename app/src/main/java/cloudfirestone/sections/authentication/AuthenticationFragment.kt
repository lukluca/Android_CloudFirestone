package cloudfirestone.sections.authentication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import cloudfirestone.infrastructure.navigation.Destination
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.navigation.listener.OnNavigateButtonClickListener
import cloudfirestone.infrastructure.network.authentication.AuthenticationAPI
import cloudfirestone.sections.MainActivity
import com.tagliabue.cloudfirestone.R
import kotlinx.android.synthetic.main.authentication_fragment.*


class AuthenticationFragment: Fragment(), OnNavigateButtonClickListener {

    var authenticationAPI: AuthenticationAPI? = null
    var navigationListener: NavigationListener? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

       val mainActivity = (activity as MainActivity)

        mainActivity.actionBarTitle = getString(R.string.menu_authentication)

        return inflater.inflate(R.layout.authentication_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        login_button.loginAPI = authenticationAPI
        create_new_account_button.navigationListener = this
    }

    override fun onDestroyView() {
        super.onDestroyView()

        login_button.loginAPI = null
    }

    override fun onNavigateClick(destination: Destination) {
        this.navigationListener?.navigateTo(destination)
    }
}