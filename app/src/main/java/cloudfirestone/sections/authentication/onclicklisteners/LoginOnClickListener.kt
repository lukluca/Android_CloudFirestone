package cloudfirestone.sections.authentication.onclicklisteners

import android.view.View
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.infrastructure.network.authentication.login.LoginAPI
import cloudfirestone.infrastructure.network.authentication.login.LoginListener
import cloudfirestone.sections.injector

class LoginOnClickListener : View.OnClickListener {

    private val loginAPI: LoginAPI = injector.apiManager

    var loginListener: LoginListener? = null

    var credential: CredentialInterface? = null

    override fun onClick(v: View?) {
        loginListener?.let { listener ->
            credential?.let {
                loginAPI.login(it.email, it.password, listener)
            }
        }
    }
}