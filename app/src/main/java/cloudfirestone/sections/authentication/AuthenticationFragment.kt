package cloudfirestone.sections.authentication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cloudfirestone.extensions.isEmailValid
import cloudfirestone.extensions.isPasswordValid
import cloudfirestone.infrastructure.model.classes.Credential
import cloudfirestone.infrastructure.model.interfaces.CredentialInterface
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

    private var email:CharSequence = ""
        set(value) {
           if (!password.isEmpty()) {
               login_button.credential = this.generateCredential(value,password)
           }
        }

    private var password:CharSequence = ""
        set(value) {
            if (!email.isEmpty()) {
                login_button.credential = this.generateCredential(email,value)
            }
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

        login_button.loginAPI = authenticationAPI
        create_new_account_button.navigationListener = this

        email_edit_text.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                s.takeIf { it.isEmailValid() }?.let {
                    this@AuthenticationFragment.email = it
                }

            }
        })

        password_edit_text.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

                s.takeIf { it.isPasswordValid() }?.let {
                    this@AuthenticationFragment.password = it
                }

            }
        })

//        email_edit_text.setOnEditorActionListener { v, actionId, event ->
//            if(actionId == EditorInfo.IME_ACTION_DONE){
//                print("Edit True")
//                true
//            } else {
//                print("Edit false")
//                false
//            }
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        login_button.loginAPI = null
    }

    override fun onNavigateClick(destination: Destination) {
        this.navigationListener?.navigateTo(destination)
    }

    private fun generateCredential(email: CharSequence, password: CharSequence): CredentialInterface {
        return Credential(email.toString(), password.toString())
    }
}