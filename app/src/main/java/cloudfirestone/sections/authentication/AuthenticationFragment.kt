package cloudfirestone.sections.authentication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import cloudfirestone.infrastructure.network.authentication.AuthenticationAPI
import cloudfirestone.sections.MainActivity
import com.tagliabue.cloudfirestone.R
import kotlinx.android.synthetic.main.authentication_fragment.*


class AuthenticationFragment: Fragment() {

    var authenticationAPI: AuthenticationAPI? = null

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
    }

    override fun onDestroyView() {
        super.onDestroyView()

        login_button.loginAPI = null
    }
}