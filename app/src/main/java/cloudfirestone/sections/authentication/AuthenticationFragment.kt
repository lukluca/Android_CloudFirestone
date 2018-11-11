package cloudfirestone.sections.authentication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
import cloudfirestone.infrastructure.navigation.interfaces.DestinationInterface
import cloudfirestone.infrastructure.navigation.listener.NavigationListener
import cloudfirestone.infrastructure.navigation.listener.OnNavigateButtonClickListener
import cloudfirestone.infrastructure.network.authentication.AuthenticationAPI
import cloudfirestone.sections.MainActivity
import cloudfirestone.sections.authentication.textwatchers.EmailTextWatcher
import cloudfirestone.sections.authentication.textwatchers.PasswordTextChanger
import cloudfirestone.sections.injector
import com.tagliabue.cloudfirestone.R
import kotlinx.android.synthetic.main.authentication_fragment.*

class AuthenticationFragment: Fragment(), OnNavigateButtonClickListener {

    var authenticationAPI: AuthenticationAPI? = null
    var navigationListener: NavigationListener? = null

    private val emailTextWatcher = EmailTextWatcher()
    private val passwordTextWatcher = PasswordTextChanger()

    private var email: CharSequence? = null
        set(value) {
            this.applyCredentialIfValid(value, password)
            field = value
        }

    private var password: CharSequence? = null
        set(value) {
            this.applyCredentialIfValid(email, value)
            field = value
        }

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

        create_new_account_button.navigationListener = this

        passwordTextWatcher.validation = {
            this.password = it
        }

        emailTextWatcher.validation = {
            this.email = it
        }

        email_edit_text.addTextChangedListener(emailTextWatcher)

        password_edit_text.addTextChangedListener(passwordTextWatcher)
    }

    override fun onNavigateClick(destination: DestinationInterface) {
        this.navigationListener?.navigateTo(destination)
    }

    private fun applyCredentialIfValid(email: CharSequence?, password: CharSequence?) {
        email?.let {
            password?.let {
                this.login_button.credential = generateCredential(email, password)
            }
        }
    }

    private fun generateCredential(email: CharSequence, password: CharSequence): CredentialInterface {
        return injector.credentialBuilder
                .email(email.toString())
                .password(password.toString())
                .build()
    }
}